pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Quality') {
            steps {
                sh 'mvn checkstyle:check pmd:check spotbugs:check'
            }
        }
    }
}
