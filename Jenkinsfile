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
        stage("Push image to DockerHub") {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerpwd', variable: 'dockerpwd')]) {
                        bat "docker login -u szalaigeri -p ${dockerpwd}"
                    }
                    bat "docker push szalaigeri/test"
                }
            }
        }
        stage("Deploy to k8s") {
            steps {
                script {
                    bat "kubectl version"
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