class HOF {

    fun performOperation(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
        return operation(x, y)
    }
}

fun main(){
    val hof = HOF()
    val sum = hof.performOperation(8, 7, {a,b -> a + b})
    val product = hof.performOperation(8,7, {a,b -> a * b})

    println("Sum : $sum ")
    println("Product : $product")
}