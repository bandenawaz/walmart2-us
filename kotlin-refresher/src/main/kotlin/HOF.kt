class HOF {

    fun performOperation(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
        return operation(x, y)
    }

    //function to demonstrate extensions
    //extension function to swap elements in a Mutable list

}

fun <T> MutableList<T>.swap(index1: Int, index2: Int){
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

fun main(){
    val hof = HOF()
    val sum = hof.performOperation(8, 7, {a,b -> a + b})
    val product = hof.performOperation(8,7, {a,b -> a * b})

    println("Sum : $sum ")
    println("Product : $product")

    val list = mutableListOf(1,2,3,4,5,6)
    println("Original List : $list")

    //Using the extension function to swap elements
    list.swap(0,2)
    println("List after swapping : $list")
}