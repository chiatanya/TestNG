pipeline {
    agent any // Use any available agent/node
    stages {
        stage('Clean') {
            steps {
                echo 'Cleaning the workspace...'
                bat 'mvn clean'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                bat 'mvn test'
            }
        }
        stage('Package') {
            steps {
                echo 'Packaging the application...'
                bat 'mvn package'
            }
        }
    }
    
    }
}
