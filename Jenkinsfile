pipeline{
    agent any

    stages {
        stage("Build") {
            steps {
                bat "mvn -version"
                bat "mvn clean install"
            }
        }
        stage("Create Docker image") {
            steps {
                script {
                    bat "docker build -t szalaigeri/test ."
                }
            }
        }
    }
    /*
    post {
        always {
            cleanWs()
        }
    }
    */
}