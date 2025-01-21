open class Payment {
    open fun processPayment(amount: Double){
        println("Processing payment of $amount")
    }
}

class CreditCardPayment: Payment() {
    override fun processPayment(amount: Double){
        println("Processing credit card payment of $amount")
    }
}

class PayPalPayment: Payment() {
    override fun processPayment(amount: Double){
        println("Processing PayPal payment of $amount")
    }
}

fun main(){
    val payment : Payment = CreditCardPayment()
    payment.processPayment(100.0)
    val payment2 : Payment = PayPalPayment()
    payment2.processPayment(200.0)
}

//Task: Add few more payment methods, and use switch statement for each payment method
