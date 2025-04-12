def call(String buildResult) {
    def color
    def message

    switch(buildResult) {
        case "SUCCESS":
            color = "good"
            message = "✅ SUCCESS: Job ${env.JOB_NAME} #${env.BUILD_NUMBER}"
            break
        case "FAILURE":
            color = "danger"
            message = "❌ FAILURE: Job ${env.JOB_NAME} #${env.BUILD_NUMBER}"
            break
        case "UNSTABLE":
            color = "warning"
            message = "⚠️ UNSTABLE: Job ${env.JOB_NAME} #${env.BUILD_NUMBER}"
            break
        default:
            color = "#cccccc"
            message = "❓ UNKNOWN STATUS: Job ${env.JOB_NAME} #${env.BUILD_NUMBER}"
    }

    slackSend(channel: '#all-cybertech', color: color, message: message)
}
