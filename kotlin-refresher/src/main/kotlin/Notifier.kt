interface Notifier {
    fun sendNotification(message: String)
}

class EmailNotifier: Notifier {
    override fun sendNotification(message: String){
        println("Sending email notification: $message")
    }
}

class SMSNotifier: Notifier {
    override fun sendNotification(message: String){
        println("Sending SMS notification: $message")
    }
}

fun main(){
    val notifiers: List<Notifier> = listOf(EmailNotifier(), SMSNotifier())
    for (notifier in notifiers){
        notifier.sendNotification("Your order has been shipped...!")
    }
}