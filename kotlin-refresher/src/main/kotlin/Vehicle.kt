open class Vehicle(val brand: String, val model: String) {

    open fun start() {
        println("Starting the Vehicle with $brand  $model")
    }

    fun stop() {
        println("Stopping the Vehicle with $brand  $model")
    }
}

//Subclass
class Car(brand: String, model: String, val numberOfDoors: Int) : Vehicle(brand, model) {

    override fun start() {
        super.start()
        println("Starting the Vehicle with $brand  $model car with $numberOfDoors Doors")
    }
    fun drive() {
        println("Driving the Car with $brand  $model")
    }
}

fun main(){
    val vehicle = Vehicle("Toyota", "Camry")
    val car = Car("Honda", "Civic Car", 4)

    vehicle.start()
    car.start()
    car.drive()
    car.stop()
    vehicle.stop()
}