def call(String DockerUser, String DockerPass, String ProjectName, String ImageTags){
  withCredentials([usernamePassword(
                    credentialsId:"DockerHub-cred",
                    usernameVariable:"dockerHubUser", 
                    passwordVariable:"dockerHubPass")]){
                sh 'echo ${DockerPass} | docker login -u ${DockerUser} --password-stdin'
                sh "docker image tag ${ProjectName}:${ImageTags} ${env.dockerHubUser}/${ProjectName}:${ImageTags}"
                sh "docker push ${env.dockerHubUser}/${ProjectName}:${ImageTags}"
   }
}
