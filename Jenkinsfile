def library
node {
  checkout scm
  result = load('releng/Jenkinsfile.groovy').org.eclipse.rcptt.jenkins.Build.new(this)
  assert result != null
  library = result
}

pipeline {
  agent {
    kubernetes {
      label 'rcptt-build-agent-3.5.4'
      yaml library.YAML_BUILD_AGENT
    }
  }

  stages {
    stage('Start Build and Test') {
      steps {
        script {
          library.build_and_test(false)
        }
      }
    }
  }

  post {
    always {
      script {
        library.post_build_actions()
      }
    }
  }
}
