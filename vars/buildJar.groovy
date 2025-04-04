#!/user/bin/env groovy

def call() {
    echo "building the application for git-branch $GIT_BRANCH and for branch $BRANCH_NAME"
    sh 'mvn package'


}