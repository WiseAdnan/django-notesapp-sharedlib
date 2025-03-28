def call(String ProjectName, String ImageTags){
  withCredentials([usernamePassword(
                    credentialsId:"DockerHub-cred",
                    usernameVariable:"dockerHubUser", 
                    passwordVariable:"dockerHubPass")]){

    withEnv(["DOCKER_USER=$dockerHubUser", "DOCKER_PASS=$dockerHubPass"]) {
                sh "echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin"
                sh "docker image tag ${ProjectName}:${ImageTags} \$DOCKER_USER/${ProjectName}:${ImageTags}"
                sh "docker push \$DOCKER_USER/${ProjectName}:${ImageTags}"
   }
}
}
}


