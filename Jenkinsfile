pipeline {
  agent {
    docker {
      image 'maven:3.5-jdk-8'
    }

  }
  triggers {
    cron('*/2 * * * *')
    }
  stages {
  stage {
    when {
      expression { env.BRANCH_NAME == 'master' }
      }

    steps {
      echo "Starting Prod"
    }
    }
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
