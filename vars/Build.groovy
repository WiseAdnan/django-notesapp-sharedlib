def call(String ImageName, String tags, String Username){
echo 'this is a build step'
sh: "docker build -t "${ImageName}" ."
}
