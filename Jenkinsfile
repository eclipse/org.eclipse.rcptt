
def loadLibrary() {
  result = load('releng/Jenkinsfile.groovy').org.eclipse.rcptt.jenkins.Build.new(this)
  assert result != null
}

pipeline {
  agent {
    kubernetes {
      label 'rcptt-build-agent-3.5.4'
      yaml loadLibrary().YAML_BUILD_AGENT
    }
  }

  stages {
    stage('Start Build and Test') {
      steps {
        script {
          loadLibrary().build_and_test(false)
        }
      }
    }
  }

  post {
    always {
      script {
        loadLibrary().post_build_actions()
      }
    }
  }
}
