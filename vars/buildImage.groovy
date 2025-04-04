#!/user/bin/env groovy

def call() {

    echo "buidling the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhublogin', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t chisom444/demo-images:jma-2.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push chisom444/demo-images:jma-2.0'

    }
}