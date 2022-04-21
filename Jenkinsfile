pipeline {

    environment {
        VERSION = sh(script: 'git rev-parse HEAD', returnStdout: true).trim()
//         registry = ""
    }

    agent any

    stages {

        stage('Clean'){
            steps{
                echo 'Executing clean ...'
                sh './mvnw clean'
            }
        }
        stage('Build'){
            steps{
                echo 'Building ...'
                sh './mvnw install'
            }
        }

        stage('Test'){
            steps{
                echo 'Test example codes'
                sh './mvnw test'
            }

        }


        stage('Docker build'){
            steps{
                echo 'Building docker image...'
//                 sh 'docker build -t ${registry} .'
//                 echo 'tag with git commit'
//                 sh 'echo "VERSION is $VERSION"'
//                 sh 'docker tag ${registry}:latest ${registry}:${VERSION}'

            }
        }

        stage('Docker push'){
            steps{
                echo 'Pushing docker image ...'
//                 sh 'docker push ${registry}:${VERSION}'
            }
        }

    }
}