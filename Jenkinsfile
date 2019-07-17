pipeline {
  agent {
    kubernetes {
      label 'rcptt-build-agent'
      yaml """
apiVersion: v1
kind: Pod
spec:
  containers:
  - name: ubuntu
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
  volumes:
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
    }
  }
  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    stage('Build') {
      steps {
        container('ubuntu') {
          sh './build.sh -Dmaven.repo.local=$WORKSPACE/m2 -e'
          sh './build_runner.sh -Dmaven.repo.local=$WORKSPACE/m2 -e'
          sh 'mvn -f maven-plugin/pom.xml clean verify -Dmaven.repo.local=$WORKSPACE/m2 -e'
        }
      }
    }
    stage('Archive'){
      steps {
        fingerprint 'runtime/updates/org.eclipse.rcptt.updates.runtime*/q7/**/*.*'
        archiveArtifacts allowEmptyArchive: true, artifacts: 'repository/full/target/repository/**/*, repository/full/target/products/*, runner/product/target/*.zip'
      }
    }
    stage('RCPTT Tests'){
      steps {
        container('ubuntu') {
          sh '. repository/full/target/publisher.properties && \
              mvn clean verify -B -f $WORKSPACE/rcpttTests/pom.xml \
              -Dmaven.repo.local=$WORKSPACE/m2 -e \
              -Dci-maven-version=2.0.0-SNAPSHOT \
              -DexplicitRunner=`readlink -f $WORKSPACE/runner/product/target/rcptt.runner-${productVersion}-SNAPSHOT.zip` \
              -DrcpttPath=$WORKSPACE/repository/full/target/products/org.eclipse.rcptt.platform.product-linux.gtk.x86_64.zip \
              || true'
          sh 'test -f $WORKSPACE/rcpttTests/target/results/tests.html'
        }       
      }
    }
    stage('Mockup Tests'){
      steps {
        container('ubuntu') {
          git 'https://github.com/DudaevAR/q7.quality.mockups.git'
          sh '. repository/full/target/publisher.properties && \
              mvn clean verify -B -f $WORKSPACE/tests/pom.xml \
              -Dmaven.repo.local=$WORKSPACE/m2 -e \
              -Dci-maven-version=2.0.0-SNAPSHOT \
              -DexplicitRunner=`readlink -f $WORKSPACE/runner/product/target/rcptt.runner-${productVersion}-SNAPSHOT.zip` \
              -DmockupsRepository=https://ci-staging.eclipse.org/rcptt/view/migration/job/mockups/lastSuccessfulBuild/artifact/repository/target/repository/ \
              || true'
          sh 'test -f $WORKSPACE/tests/target/results/tests.html'
        }
      }
    }
  }
  post {
    always {
      junit '**/target/*-reports/*.xml'
      archiveArtifacts allowEmptyArchive: true, artifacts: '*ests/target/results/**/*, *ests/target/**/*err*log, *ests/target/runner/configuration/*.log, *ests/target/runner-workspace/**/*, *ests/target/**/.log'
      sh 'dd if=/dev/zero of=file.txt count=100 bs=1048576' // 1048576 bytes = 1Mb
      sh 'ps x'
    }
  }
}