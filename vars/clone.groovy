def call (String url, String branch) {
  // echo "This is cloning the code"
  // git url: "https://github.com/LondheShubham153/django-notes-app", branch: "main"
  git url: "${url}", branch: "${branch}"
  // echo "Code cloning is successfully"
}
