pipeline {
  agent any
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
    agent {
      docker {
        image 'maven:3.5-jdk-8'
      }

    }
      steps {
        sh 'mvn test'
      }
    }
    stage('Maven Build ') {
    agent {
      docker {
        image 'maven:3.5-jdk-8'
      }

    }
      steps {

        sh 'mvn package'
      }
    }
    stage("build_push_image") {
    
      steps {
        script {
          dir(env.WORKSPACE) {
            def image = docker.build("knowledgemeet:latest",'.')
          }

        }
      }
    }

  }
}
