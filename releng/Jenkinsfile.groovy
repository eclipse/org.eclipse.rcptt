/*******************************************************************************
* Copyright (c) 2019 Xored Software Inc and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*  
* Contributors:
* 	Xored Software Inc - initial API and implementation and/or initial documentation
********************************************************************************/
// The container does not start under the Jenkins user. /home/jenkins is mounted in a container and is a single file space
BUILD_CONTAINER_NAME="ubuntu"
BUILD_CONTAINER="""
  - name: $BUILD_CONTAINER_NAME
    image: dudaevar/ubuntu-rcptt
    tty: true
    resources:
      limits:
        memory: "4Gi"
        cpu: "1"
      requests:
        memory: "4Gi"
        cpu: "1"
    env:
    - name: "MAVEN_OPTS"
      value: "-Duser.home=/home/jenkins"
    volumeMounts:
    - name: settings-xml
      mountPath: /home/jenkins/.m2/settings.xml
      subPath: settings.xml
      readOnly: true
    - name: toolchains-xml
      mountPath: /home/jenkins/.m2/toolchains.xml
      subPath: toolchains.xml
      readOnly: true
    - name: settings-security-xml
      mountPath: /home/jenkins/.m2/settings-security.xml
      subPath: settings-security.xml
      readOnly: true
    - name: m2-repo
      mountPath: /home/jenkins/.m2/repository"""
BUILD_CONTAINER_VOLUMES="""
  - name: settings-xml
    secret:
      secretName: m2-secret-dir
      items:
      - key: settings.xml
        path: settings.xml
  - name: toolchains-xml
    configMap:
      name: m2-dir
      items:
      - key: toolchains.xml
        path: toolchains.xml
  - name: settings-security-xml
    secret:
      secretName: m2-secret-dir
      items:
      - key: settings-security.xml
        path: settings-security.xml
  - name: m2-repo
    emptyDir: {}"""
SSH_DEPLOY_CONTAINER_NAME="jnlp"
SSH_DEPLOY_CONTAINER="""
  - name: $SSH_DEPLOY_CONTAINER_NAME
    volumeMounts:
    - name: volume-known-hosts
      mountPath: /home/jenkins/.ssh"""
SSH_DEPLOY_CONTAINER_VOLUMES="""
  - name: volume-known-hosts
    configMap:
      name: known-hosts"""

env.YAML_BUILD_AGENT="""
apiVersion: v1
kind: Pod
spec:
  containers:
$BUILD_CONTAINER
  volumes:
$BUILD_CONTAINER_VOLUMES
"""

env.YAML_BUILD_AND_DEPLOY_AGENT="""
apiVersion: v1
kind: Pod
spec:
  containers:
$BUILD_CONTAINER
$SSH_DEPLOY_CONTAINER
  volumes:
$BUILD_CONTAINER_VOLUMES
$SSH_DEPLOY_CONTAINER_VOLUMES
"""

CREDENTIAL="genie.rcptt@projects-storage.eclipse.org"
SSH_CLIENT="ssh $CREDENTIAL"

FULL_REPOSITORY_TARGET="repository/full/target"
RCPTT_REPOSITORY_TARGET="repository/rcptt/target"
PRODUCTS_DIR="$FULL_REPOSITORY_TARGET/products"
FULL_REPOSITORY_DIR="$FULL_REPOSITORY_TARGET/repository"
RCPTT_REPOSITORY_DIR="$RCPTT_REPOSITORY_TARGET/repository"
RUNNER_DIR="runner/product/target"
RUNTIME_DIR="runtime/updates"
RUNTIME_DIR_E3="$RUNTIME_DIR/org.eclipse.rcptt.updates.runtime/q7"
RUNTIME_DIR_E4="$RUNTIME_DIR/org.eclipse.rcptt.updates.runtime.e4x/q7"
DOC_DIR="releng/doc"

DOWNLOADS_HOME="/home/data/httpd/download.eclipse.org/rcptt"

def build_and_test(Boolean sign) {
    stage("Build") {
        build(sign)
        echo "Version: ${get_version()}"
        echo "Qualifier: ${get_qualifier()}"
    }
    stage("Archive") {
        archive()
    }
    stage("RCPTT Test") {
        rcptt_tests()
    }
    stage("Mockup Test") {
        mockup_tests()
    }
}

def set_milestone(String decorator) {
    container(BUILD_CONTAINER_NAME) {
      version = get_version_from_pom().split("-")[0]
      sh "./update_version.sh $version $decorator"
    }
}

def build(Boolean sign) {
  container(BUILD_CONTAINER_NAME) {
    sh "./build.sh -Dmaven.repo.local=$WORKSPACE/m2 -B -e ${sign ? "-P sign" : ""}"
    sh "./build_runner.sh -Dmaven.repo.local=$WORKSPACE/m2 -B -e"
    sh "mvn -f maven-plugin/pom.xml clean verify -Dmaven.repo.local=$WORKSPACE/m2 -B -e"
    sh "./$DOC_DIR/generate-doc.sh -Dmaven.repo.local=$WORKSPACE/m2 -B -e"
  }
}

def archive() {
  fingerprint "$RUNTIME_DIR/org.eclipse.rcptt.updates.runtime*/q7/**/*.*"
  archiveArtifacts allowEmptyArchive: true, artifacts: "$FULL_REPOSITORY_DIR/**/*, $PRODUCTS_DIR/*, $RUNNER_DIR/*.zip, maven-plugin/rcptt-maven-*/target/rcptt-maven-*.jar, $DOC_DIR/target/doc/**/*"
}

def sh_with_return(String command) {
  def res = sh (
    script: command,
    returnStdout: true
  ).trim()
  return res
}

def get_version_from_pom() {
  return sh_with_return("mvn -q -Dexec.executable=echo -Dexec.args='\${project.version}' --non-recursive exec:exec -f releng/pom.xml")
}

def get_version() {
  return sh_with_return(". $FULL_REPOSITORY_TARGET/publisher.properties && echo \$productVersion")
}

def get_qualifier() {
  return sh_with_return(". $FULL_REPOSITORY_TARGET/publisher.properties && echo \$productQualifier")
}

def rcptt_tests() {
  container(BUILD_CONTAINER_NAME) {
    def version = get_version()
    sh "mvn clean verify -B -f rcpttTests/pom.xml \
        -Dmaven.repo.local=$WORKSPACE/m2 -e \
        -Dci-maven-version=2.0.0-SNAPSHOT \
        -DexplicitRunner=`readlink -f $WORKSPACE/$RUNNER_DIR/rcptt.runner-*.zip` \
        -DrcpttPath=$WORKSPACE/$PRODUCTS_DIR/org.eclipse.rcptt.platform.product-linux.gtk.x86_64.zip \
        || true"
    sh "test -f $WORKSPACE/rcpttTests/target/results/tests.html"
  }
}

def mockup_tests() {
  container(BUILD_CONTAINER_NAME) {
    def version = get_version()
    dir('mockups') {
        git "https://github.com/DudaevAR/q7.quality.mockups.git"
        sh "mvn clean verify -B -f tests/pom.xml \
            -Dmaven.repo.local=$WORKSPACE/m2 -e \
            -Dci-maven-version=2.0.0-SNAPSHOT \
            -DexplicitRunner=`readlink -f $WORKSPACE/$RUNNER_DIR/rcptt.runner-*.zip` \
            -DmockupsRepository=https://ci.eclipse.org/rcptt/job/mockups/lastSuccessfulBuild/artifact/repository/target/repository \
            || true"
        sh "test -f $WORKSPACE/mockups/tests/target/results/tests.html"
    }
  }
}

def post_build_actions() {
  junit "**/target/*-reports/*.xml"
  archiveArtifacts allowEmptyArchive: true, artifacts: "rcpttTests/target/results/**/*, rcpttTests/target/**/*err*log, rcpttTests/target/runner/configuration/*.log, rcpttTests/target/runner-workspace/**/*, rcpttTests/target/**/.log, mockups/tests/target/results/**/*, mockups/tests/target/**/*err*log, mockups/tests/target/runner/configuration/*.log, mockups/tests/target/runner-workspace/**/*, mockups/tests/target/**/.log"

  sh "dd if=/dev/zero of=file.txt count=100 bs=1048576" // 1048576 bytes = 1Mb
  sh "rm file.txt"

  sh "ps x"
}

def deploy(String mode, String arg = "M0") {
  switch(mode) {
    case "Release": release(); break;
    case "Milestone": milestone(arg); break;
    case "Nightly": nightly(); break;
  }
}

def get_version_storage_folder(String type, String version) {
  return "$DOWNLOADS_HOME/$type/$version"
}

def get_storage_folder(String type, String version, String subfolder) {
  return "${get_version_storage_folder(type, version)}/$subfolder"
}

def nightly() {
  def buildsToKeep = 5

  def type = "nightly"
  def version = get_version()
  def qualifier = get_qualifier()
  def qualifiedDecoration = "-N$qualifier"

  container(SSH_DEPLOY_CONTAINER_NAME) {
    copy_files(type, version, qualifier, qualifiedDecoration, true)
    def storageFolder = get_version_storage_folder(type, version)
    sshagent(["projects-storage.eclipse.org-bot-ssh"]) {
      def oldBuilds = sh_with_return("$SSH_CLIENT ls -r $storageFolder | grep -v latest | tail -n +${buildsToKeep + 1}")
      for(old in oldBuilds.split("\n")) {
        sh "$SSH_CLIENT rm -r $storageFolder/$old"
      }
    }

    def storageFolderLatest = get_storage_folder(type, version, "latest")
    sshagent(["projects-storage.eclipse.org-bot-ssh"]) {
      sh "$SSH_CLIENT rm -rf ${storageFolderLatest}"
    }
    copy_files(type, version, "latest", "-nightly", true)
  }

  maven_deploy_nightly()
}

def milestone(String milestone) {
  def type = "milestone"
  def version = get_version()
  def qualifiedDecoration = "-$milestone"

  container(SSH_DEPLOY_CONTAINER_NAME) {
    copy_files(type, version, milestone, qualifiedDecoration, false)
  }

  maven_deploy("$version-$milestone")
}

def release() {
  def type = "release"
  def version = get_version()
  def qualifiedDecoration = ""

  container(SSH_DEPLOY_CONTAINER_NAME) {
    copy_files(type, version, "", qualifiedDecoration, false)
  }

  maven_deploy(version)
}

def copy_files(String type, String version, String subfolder, String qualifiedDecoration, Boolean copy_full) { // subfolder is empty for type == release
  def storageFolder = get_storage_folder(type, version, subfolder)

  sshagent(["projects-storage.eclipse.org-bot-ssh"]) {
    sh "$SSH_CLIENT test -d $storageFolder && echo $type ${version}${qualifiedDecoration} already exists && exit 1 || echo $type ${version}${qualifiedDecoration} does not exist yet"

    sh "$SSH_CLIENT mkdir -p $storageFolder"
    sh "$SSH_CLIENT mkdir $storageFolder/runner"

    for(item in [ [ RCPTT_REPOSITORY_DIR, "repository" ],
                  [ RUNTIME_DIR_E3, "runtime3x" ],
                  [ RUNTIME_DIR_E4, "runtime4x" ],
                  [ "$DOC_DIR/target/doc", "doc" ],
                  [ "$RCPTT_REPOSITORY_TARGET/rcptt.repository-*.zip", "repository-${version}${qualifiedDecoration}.zip" ],
                  [ "$RUNNER_DIR/rcptt.runner-*.zip", "runner/rcptt.runner-${version}${qualifiedDecoration}.zip" ] ]) {
      sh "scp -r ${item[0]} $CREDENTIAL:$storageFolder/${item[1]}"
    }

    sh "$SSH_CLIENT mkdir $storageFolder/ide"
    for(platform in ["linux.gtk", "macosx.cocoa", "win32.win32"]) {
      sh "scp -r $PRODUCTS_DIR/org.eclipse.rcptt.platform.product-${platform}.x86_64.zip $CREDENTIAL:$storageFolder/ide/rcptt.ide-${version}${qualifiedDecoration}-${platform}.x86_64.zip"
    }

    if(copy_full) {
      sh "scp -r $FULL_REPOSITORY_DIR $CREDENTIAL:$storageFolder/full"
    }

  }
}

def maven_deploy_nightly() {
  container(BUILD_CONTAINER_NAME) {
    sh "mvn -f releng/runner/pom.xml clean deploy -Dmaven.repo.local=$WORKSPACE/m2 -e -B"
    sh "mvn -f maven-plugin/pom.xml clean deploy -Dmaven.repo.local=$WORKSPACE/m2 -e -B"
  }
}

def maven_deploy(String version) {
  maven_deploy_runner(version)
  maven_deploy_maven_plugin(version)
}

def maven_deploy_runner(String version) {
  container(BUILD_CONTAINER_NAME) {
    sh "mvn deploy:deploy-file -B \
        -Dversion=$version -Durl=https://repo.eclipse.org/content/repositories/rcptt-releases/ \
        -DgroupId=org.eclipse.rcptt.runner \
        -DrepositoryId=repo.eclipse.org \
        -DgeneratePom=true \
        -DartifactId=rcptt.runner \
        -Dfile=`readlink -f $WORKSPACE/$RUNNER_DIR/rcptt.runner-*.zip`"
  }
}

def maven_deploy_maven_plugin(String version){
  container(BUILD_CONTAINER_NAME) {
    sh "mvn -f maven-plugin/pom.xml clean versions:set -DnewVersion=$version -B"
    sh "mvn -f maven-plugin/pom.xml clean deploy -B"
  }
}

return this