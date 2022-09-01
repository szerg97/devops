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
                bat "echo Fake deployment"
                /*
                sshagent(['k8s']) {
                    bat "scp -o StrictHostKeyChecking=no test deployment.yaml szalaigeri@LAPTOP-H25DL4Q7"
                    script {
                        try {
                            bat "ssh szalaigeri@LAPTOP-H25DL4Q7 kubectl apply -f ."
                        } catch (error){
                            bat "ssh szalaigeri@LAPTOP-H25DL4Q7 kubectl create -f ."
                        }
                    }
                }
                */
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