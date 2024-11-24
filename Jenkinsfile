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
		stage("consolidate Results"){
			steps{
				input("Do you want to capture the results")
				junit '*target/surefire-reports/junitreports/TEST-*.xml'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
				echo 'Test results and JAR file archived successfully.'

		}	
    } 
	 stage("Email Build"){
		steps{
		mail bcc: '', body: 'Chill just the Error Test', cc: '', from: '', replyTo: '', subject: 'Error in something', to: 'chegde99@gmail.com'
		}
	 }
    
    }
}

