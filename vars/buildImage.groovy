#!/user/bin/env groovy

def call(String imageName) {

    echo "buidling the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhublogin', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t $imageName ."
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh "docker push $imageName"

    }


}