pipeline {
    agent any

    stages {
        stage('Git repository clone') {
            steps {
                git branch: 'main', url: 'https://github.com/HoChoRoo/first-jenkins-sample'
            }
        }
        stage('Gradle build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean build'
            }    
        }
        stage('Send .jar to spring ec2 & Deploy') {
            steps {
                sshagent(credentials: ['from-jenkins-to-aws-ec2-access-key']) {
                    sh '''
                        ssh -o StrictHostKeyChecking=no ubuntu@172.31.35.18 uptime
                        scp build/libs/demo-0.0.1-SNAPSHOT.jar ubuntu@172.31.35.18:/home/ubuntu/mydemo
                        ssh -t ubuntu@172.31.35.18 sudo chmod +x ./deploy.sh
                        ssh -t ubuntu@172.31.35.18 ./deploy.sh
                    '''
                }
            }
        }
    }
}
