abstract class Employee(val name: String) {

    abstract fun calculateSalary(): Double

    fun displayInfo(){
        println("Employee name is ${name} and salary is ${calculateSalary()}")
    }
}

class FullTimeEmployee(name: String, val annualSalary: Double) : Employee(name){

    override fun calculateSalary(): Double {
        return annualSalary / 12
    }
}

class Intern(name: String, val hourlyRate: Double, val hoursWorked: Int) : Employee(name) {
    override fun calculateSalary(): Double {
        return hourlyRate * hoursWorked
    }

}

fun main(){
    val galina= FullTimeEmployee("galina",120000.0)
    galina.displayInfo()

    val nawaz = Intern("Nawaz", 100.0, 10)
    nawaz.displayInfo()
}