class MyClass {

    private val privateProperty = "This is private property"
    private fun privateFunction()  {
        println("This is private function")
    }

    fun publicFunction(){
        println("This is public function")
        println(privateProperty)
        privateFunction()
    }
}

fun main(){
    val myObject = MyClass()
    myObject.publicFunction()
    
//    //lets access the provate functin and property from outside the class
//    println(myObject.privateProperty)
//    myObject.privateFunction()
}