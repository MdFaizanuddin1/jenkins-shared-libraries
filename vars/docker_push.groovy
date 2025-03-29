def call(String ProjectName, String ImageTag, String DockerHubUser, String DockerHubPassword) {
   script {
     withCredentials([usernamePassword(credentialsId: 'dockerHubCred', 
                    usernameVariable: 'dockerHubUser', 
                    passwordVariable: 'dockerHubPass')]){

  sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
  // sh "docker image tag notes-app:latest ${dockerHubUser}/notes-app:latest"
  sh "docker push ${dockerHubUser}/${ProjectName}:${ImageTag}"
     }
   }
}

// def call(String ProjectName, String ImageTag, String DockerHubUser, String DockerHubPassword) {
//     script {
//         withCredentials([usernamePassword(credentialsId: 'dockerHubCred', 
//                         usernameVariable: 'dockerHubUser', 
//                         passwordVariable: 'dockerHubPass')]) {
            
//             // Login to Docker Hub
//             sh "echo '${dockerHubPass}' | docker login -u '${dockerHubUser}' --password-stdin"

//             // Tag the image dynamically
//             sh "docker image tag ${ProjectName}:latest ${dockerHubUser}/${ProjectName}:${ImageTag}"

//             // Push the image
//             sh "docker push ${dockerHubUser}/${ProjectName}:${ImageTag}"

//             echo "✅ Docker image pushed successfully: ${dockerHubUser}/${ProjectName}:${ImageTag}"
//         }
//     }
// }
