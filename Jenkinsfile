pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Test') {
            steps {
                sg 'mvn clean test'
            }
        }
        stage('Install') {
            steps {
                sg 'mvn install'
            }
        }
    }
}