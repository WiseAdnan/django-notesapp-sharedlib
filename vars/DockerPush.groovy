def call(String ProjectName, String ImageTags){
  withCredentials([usernamePassword(
                    credentialsId:"DockerHub-cred",
                    usernameVariable:"dockerHubUser", 
                    passwordVariable:"dockerHubPass")]){
                sh "echo $dockerHubPass | docker login -u $dockerHubUser --password-stdin"
                sh "docker image tag ${ProjectName}:${ImageTags} $dockerHubUser/${ProjectName}:${ImageTags}"
                sh "docker push $dockerHubUser/${ProjectName}:${ImageTags}"
   }
}
