fun main(args: Array<String>) {

    println("Hello to everyone")
    println("Welcome to Kotlin Programming")

    var a: Int = 10
    val b: Int = 20

    println(a)
    println(b)

    var myName: String = "Nawaz"
    println("Hello,$myName") // println()

    val emptyString = String()
    println(emptyString)

    for (n in myName){
        println(n)
    }

    val sum = "The sum of $a and $b is ${a + b}"
    println(sum)

    //Type Casting
    val celsiusValue = Celsius(25.0)
    val fahrenheitValue = celsiusValue.toFahrenheit()
    println("Celsius to Fahrenheit: ${fahrenheitValue.value}")

    val fahrenheitValue2 = Fahrenheit(77.0)
    val celsiusValue2 = fahrenheitValue2.toCelsius()
    println("Fahrenheit to Celsius: ${celsiusValue2.value}")

    //conditional programming
    val number = 10
    if(number % 2 == 0){
        println("The number $number is Even")
    }else{
        println("he number $number is Odd")
    }

}

class Celsius(val value: Double){

    fun toFahrenheit(): Fahrenheit{
        val fahrenheitValue = (value * 9/5) + 32
        return Fahrenheit(fahrenheitValue)
    }
}

class Fahrenheit(val value:Double){
    //val celsiusValue = Celsius(25.0)

   fun toCelsius():Celsius{
       val celsiusValue = (value - 32) * 5/9
       return Celsius(celsiusValue)
   }
}

