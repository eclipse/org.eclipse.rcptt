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
    volumeMounts:
    - name: settings-xml
      mountPath: /home/jenkins/.m2/settings.xml
      subPath: settings.xml
      readOnly: true
    - name: toolchains-xml
      mountPath: /home/jenkins/.m2/toolchains.xml
      subPath: toolchains.xml
      readOnly: true
    - name: m2-repo
      mountPath: /home/jenkins/.m2/repository
    - name: volume-known-hosts
      mountPath: /home/jenkins/.ssh
"""
BUILD_CONTAINER_VOLUMES="""
  - name: settings-xml
    configMap:
      name: m2-dir
      items:
      - key: settings.xml
        path: settings.xml
  - name: toolchains-xml
    configMap:
      name: m2-dir
      items:
      - key: toolchains.xml
        path: toolchains.xml
  - name: m2-repo
    emptyDir: {}
"""
DEPLOY_CONTAINER_NAME="jnlp"
DEPLOY_CONTAINER="""
  - name: $DEPLOY_CONTAINER_NAME
    volumeMounts:
    - name: volume-known-hosts
      mountPath: /home/jenkins/.ssh
"""
DEPLOY_CONTAINER_VOLUMES="""
  - name: volume-known-hosts
    configMap:
      name: known-hosts
"""

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
$DEPLOY_CONTAINER
  volumes:
$BUILD_CONTAINER_VOLUMES
$DEPLOY_CONTAINER_VOLUMES
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

def build_and_test() {
    stage("Build") {
        build()
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

def build() {
  container(BUILD_CONTAINER_NAME) {
    sh "./build.sh -P sign -Dmaven.repo.local=$WORKSPACE/m2 -e"
    sh "./build_runner.sh -Dmaven.repo.local=$WORKSPACE/m2 -e"
    sh "mvn -f maven-plugin/pom.xml clean verify -Dmaven.repo.local=$WORKSPACE/m2 -e"
    sh "./$DOC_DIR/generate-doc.sh -Dmaven.repo.local=$WORKSPACE/m2 -e"
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
        -DexplicitRunner=`readlink -f $WORKSPACE/$RUNNER_DIR/rcptt.runner-$version-SNAPSHOT.zip` \
        -DrcpttPath=$WORKSPACE/$PRODUCTS_DIR/org.eclipse.rcptt.platform.product-linux.gtk.x86_64.zip \
        || true"
    sh "test -f $WORKSPACE/rcpttTests/target/results/tests.html"
  }
}

def mockup_tests() {
  container(BUILD_CONTAINER_NAME) {
    def version = get_version()
    git "https://github.com/DudaevAR/q7.quality.mockups.git"
    sh "mvn clean verify -B -f tests/pom.xml \
        -Dmaven.repo.local=$WORKSPACE/m2 -e \
        -Dci-maven-version=2.0.0-SNAPSHOT \
        -DexplicitRunner=`readlink -f $WORKSPACE/$RUNNER_DIR/rcptt.runner-$version-SNAPSHOT.zip` \
        -DmockupsRepository=https://ci-staging.eclipse.org/rcptt/view/migration/job/mockups/lastSuccessfulBuild/artifact/repository/target/repository/ \
        || true"
    sh "test -f $WORKSPACE/tests/target/results/tests.html"
  }
}

def post_build_actions() {
  junit "**/target/*-reports/*.xml"
  archiveArtifacts allowEmptyArchive: true, artifacts: "*ests/target/results/**/*, *ests/target/**/*err*log, *ests/target/runner/configuration/*.log, *ests/target/runner-workspace/**/*, *ests/target/**/.log"

  sh "dd if=/dev/zero of=file.txt count=100 bs=1048576" // 1048576 bytes = 1Mb
  sh "rm file.txt"

  sh "ps x"
}

def deploy(String mode, String arg = "M0") {
  container(DEPLOY_CONTAINER_NAME) {
    switch(mode) {
      case "Release": release(); break;
      case "Milestone": milestone(arg); break;
      case "Nightly": nightly(); break;
    }
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

def milestone(String milestone) {
  def type = "milestone"
  def version = get_version()
  def qualifiedDecoration = "-$milestone"

  copy_files(type, version, milestone, qualifiedDecoration, false)

  maven_deploy_runner("$version-$milestone", type, milestone)
  meven_deploy_maven_plugin(version)
}

def release() {
  def type = "release"
  def version = get_version()
  def qualifiedDecoration = ""

  copy_files(type, version, "", qualifiedDecoration, false)

  maven_deploy_runner(version, type, "")
  meven_deploy_maven_plugin(version)
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
                  [ "$RCPTT_REPOSITORY_TARGET/rcptt.repository-$version-SNAPSHOT.zip", "repository-${version}${qualifiedDecoration}.zip" ],
                  [ "$RUNNER_DIR/rcptt.runner-$version-SNAPSHOT.zip", "runner/rcptt.runner-${version}${qualifiedDecoration}.zip" ] ]) {
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

def maven_deploy_runner(String version, String type, String subfolder) {
  sh "mvn deploy:deploy-file \
    -Dversion=$version -Durl=https://repo.eclipse.org/content/repositories/rcptt-releases/ \
    -DgroupId=org.eclipse.rcptt.runner \
    -DrepositoryId=repo.eclipse.org \
    -DgeneratePom=true \
    -DartifactId=rcptt.runner \
    -Dfile=https://download.eclipse.org/rcptt/${type}/${version}/${subfolder}/runner/rcptt.runner-${version}.zip"
}

def meven_deploy_maven_plugin(String version){
  sh "mvn -f maven-plugin/pom.xml clean versions:set -DnewVersion=$version"
  sh "mvn -f maven-plugin/pom.xml clean deploy -DnewVersion=$version"
}

return this