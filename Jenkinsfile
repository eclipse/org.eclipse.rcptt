def build = library(
  identifier: 'rcptt-pipeline-library@groovy',
  retriever: modernSCM(
    [
      $class: 'GitSCMSource',
      remote: 'https://github.com/xored/rcptt.git'
    ]
  )
).org.eclipse.rcptt.jenkins.Build.new(this)

pipeline {
  agent {
    kubernetes {
      label 'rcptt-build-agent-3.5.16'
      yaml build.YAML_BUILD_AGENT
    }
  }

  stages {
    stage('Start Build and Test') {
      steps {
        script {
          build.build_and_test(false)
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
