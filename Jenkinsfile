pipeline {
    agent any 
    stages {
        stage('Build') { 
            steps {
                sh "gradle clean build"
            }
        }
        stage('Package') { 
            steps {
                sh "gradle jar"
            }
        }
        stage('Publish') { 
            steps {
                sh "gradle publish publishToMavenLocal"
            }
        }
    }
}