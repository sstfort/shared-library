def call(String buildResult) {
    def color
    def message = ""

    if (buildResult == "SUCCESS") {
        color = "good"
        message = "🎉 CONGRATULATIONS: Job ${env.JOB_NAME} with build number ${env.BUILD_NUMBER} succeeded! 🚀"
    } else if (buildResult == "FAILURE") {
        color = "danger"
        message = "❌ FAILURE: Job ${env.JOB_NAME} with build number ${env.BUILD_NUMBER} failed. Check logs!"
    } else if (buildResult == "UNSTABLE") {
        color = "warning"
        message = "⚠️ UNSTABLE: Job ${env.JOB_NAME} with build number ${env.BUILD_NUMBER} is unstable."
    } else {
        color = "danger"
        message = "❗ UNKNOWN RESULT: Job ${env.JOB_NAME} with build number ${env.BUILD_NUMBER} ended with status ${buildResult}."
    }

    slackSend color: color, message: message
}
