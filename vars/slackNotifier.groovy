def call(String buildResult) {
  if ( buildResult == "SUCCESS" ) {
    slackSend color: "good", message: "CONGRATULATION: Job ${env.JOB_NAME} with buildnum>
  }
  else if( buildResult == "FAILURE" ) {
    slackSend color: "danger", message: "BAD NEWS:Job ${env.JOB_NAME} with buildnumber $>
  }
  else if( buildResult == "UNSTABLE" ) {
    slackSend color: "warning", message: "BAD NEWS:Job ${env.JOB_NAME} with buildnumber >
  }
  else {
    slackSend color: "danger", message: "BAD NEWS:Job ${env.JOB_NAME} with buildnumber $>
  }
}
