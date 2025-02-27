pipeline {
    agent any
    tools {
        maven 'Tu Maven'
    }
    stages {
        stage('checking') {
            steps {
                git branch: 'main', url: 'https://github.com/tuMetropolia/Akido.git'
            }
        }
        stage('build') {
            steps {
                sh "mvn clean install"
            }
        }

        stage('Test & Coverage') {
            steps {
                sh 'mvn test jacoco:report'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    jacoco execPattern: '**/target/jacoco.exec',
                    classPattern: '**/target/classes',
                    sourcePattern: '**/src/main/java',
                    exclusionPattern: '**/test/**'
                }
            }
        }
    }
}