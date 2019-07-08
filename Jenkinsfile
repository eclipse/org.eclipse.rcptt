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
        memory: "2Gi"
        cpu: "1"
      requests:
        memory: "2Gi"
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
    stage('Tests'){
      steps {
        container('ubuntu') {
          sh 'mvn clean verify -B -f $WORKSPACE/rcpttTests/pom.xml -Dci-maven-version=2.0.0-SNAPSHOT -DexplicitRunner=$WORKSPACE/runner/product/target/rcptt.runner-2.5.0-SNAPSHOT.zip -DrcpttPath=$WORKSPACE/repository/full/target/products/org.eclipse.rcptt.platform.product-linux.gtk.x86_64.zip || true'
          sh 'test -f $WORKSPACE/rcpttTests/target/results/tests.html'
        }       
      }
    }
  }
  post {
    always {
      junit '**/target/*-reports/*.xml'
      archiveArtifacts allowEmptyArchive: true, artifacts: 'rcpttTests/target/results/**/*, rcpttTests/target/**/*err*log, rcpttTests/target/runner-workspace/**/*, rcpttTests/target/**/.log'
    }
  }
}