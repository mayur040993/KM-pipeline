pipeline {
  agent any
  stages {
    stage('Maven  Test') {
      steps {
        sh 'mvn test'
      }
    }
    stage('Maven Build ') {
      steps {
        sh 'mvn package'
      }
    }
  }
}