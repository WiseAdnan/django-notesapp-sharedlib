def call(String branch, String credentialsId, String url) {
 branch: "${branch}",
 credentialsId: "${credentialsId}",
 url: "${url}"
 echo "Code clone successfull"
}
