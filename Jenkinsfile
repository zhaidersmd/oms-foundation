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

        post {
            success {
                echo 'Build Success'
            }
            failure {
                echo 'Build Failed'
            }
        }

    }

}
