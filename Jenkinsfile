pipeline {

agent any

stages {

stage ('checkout') {
steps {
checkout scm
}
}

stage('Build') {
steps {
bat 'mvn clean install'
}
}
}
}

