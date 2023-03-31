pipeline {
    agent any
    parameters {
            string defaultValue: 'main', name: 'BRANCH', trim: true
        }

    stages {
        stage('Git checkout') {
            steps {
                git branch: '${BRANCH}', url: 'https://github.com/piotrmielkeQA/Java_Selenium_JenkinsFile.git'
            }

        stage('Run tests') {
                    steps {
                        sh: 'mvn clean test'
                    }
                }
        stage('Generate reports tests') {
                    steps {
                        publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: '', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: '', useWrapperFileDirectly: true])
                    }
                }
        }
    }
}
