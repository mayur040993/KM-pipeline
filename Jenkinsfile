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
    stage ('UserInput') {
              when {
                  expression { env.BRANCH_NAME == 'master' }
              }
              steps {
                script {
                  try {
                    timeout(time: 20, unit: 'SECONDS') {
                      input 'Do you want to proceed to the Deployment?'
                    }
                  }
                  catch(err) {
                          err.printStackTrace()
                  }

                }
              sh 'echo Proceeding To Deployment'
              }
    }
    stage('Maven  Test') {
      steps {
        sh 'mvn test'
      }
    }
    stage('Maven Build ') {
      steps {
        script{
          stash 'KM'
        }
        sh 'mvn package'
      }
    }
    stage("build_push_image") {
      agent any
      steps {
        script {
          unstash 'KM'
          def image = docker.build("knowledgemeet:latest",'.')
        }
      }
    }
    stage("Deploy Docker Image"){
      steps{
        sh './var/lib/jenkins/docker.sh' env.BRANCH_NAME
      }
    }
  }
}
