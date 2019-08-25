def groovy

pipeline {
  agent none

  stages {

    stage('Load groovy script') {
      agent any
      stages {
        stage('Checkout') {
          steps {
            checkout scm
            script {
              groovy = load('releng/Jenkinsfile.groovy')
            }
          }
        }
      }
    }

    stage('Launch agent') {
      agent {
        kubernetes {
          label 'rcptt-build-agent'
          yaml "${env.YAML_BUILD_AGENT}"
        }
      }
      stages {
        stage('Start Build and Test') {
          steps {
            script {
              groovy.build_and_test(false)
            }
          }
        }
      }
      post {
        always {
          script {
            groovy.post_build_actions()
          }
        }
      }
    }

  }
}