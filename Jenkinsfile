pipeline {
    agent any

    tools {
        maven 'maven-3'
        jdk 'jdk-8'
    }

    environment {
        APP_NAME = "oms-foundation"
        DOCKER_IMAGE = "yourdockerhub/oms-foundation"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/zhaidersmd/oms-foundation.git'
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Image') {
            steps {
                sh "docker build -t oms-foundation:1.0 ."
                sh "docker tag oms-foundation:1.0 137146002396.ecr/oms-foundation:latest"
            }


        }
        

    }
    post {
            success {
                echo 'Build Success'
            }
            failure {
                echo 'Build Failed'
            }
        }

}