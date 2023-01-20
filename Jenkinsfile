
def loadLibrary() {
  result = load('releng/Jenkinsfile.groovy').org.eclipse.rcptt.jenkins.Build.new(this)
  assert result != null
}

pipeline {
  environment {
     build = loadLibrary()
  }
  agent {
    kubernetes {
      label 'rcptt-build-agent-3.5.4'
      yaml env.build.YAML_BUILD_AGENT
    }
  }

  stages {
    stage('Start Build and Test') {
      steps {
        script {
          build = env.build
          env.build.build_and_test(false)
        }
      }
    }
  }

  post {
    always {
      script {
        build.post_build_actions()
      }
    }
  }
}
