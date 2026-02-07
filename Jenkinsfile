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

        stage('Build Image and push to ECR') {
            steps {
				sh "aws ecr get-login-password --region ap-south-1 | docker login --username AWS --password-stdin 137146002396.dkr.ecr.ap-south-1.amazonaws.com"
                sh "docker build -t my-docker-repo ."
                sh "docker tag my-docker-repo:latest 137146002396.dkr.ecr.ap-south-1.amazonaws.com/my-docker-repo:latest"
                sh "docker push 137146002396.dkr.ecr.ap-south-1.amazonaws.com/my-docker-repo:latest"
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