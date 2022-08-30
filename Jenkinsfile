pipeline{
    agent any

    stages {
        stage("Build") {
            steps {
                bat "mvn -version"
                bat "mvn clean install"
            }
        }
        stage("Test") {
            steps {
                bat "echo Fake testing..."
            }
        }
        stage("Deploy") {
            steps {
                bat "kubectl apply -f .\\deployment.yaml"
                bat "kubectl expose deployment test --port=8080 --target-port=8081 --type=LoadBalancer"
                //bat "echo Fake deploying..."
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