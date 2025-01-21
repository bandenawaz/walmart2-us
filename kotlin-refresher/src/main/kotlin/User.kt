class User(val name: String, val email: String) {

    var membershipType: String = "Basic"

    //Secondary Constructor
    constructor(name: String, email: String, membershipType: String): this(name, email){
        this.membershipType = membershipType

        println("User created: $name with $membershipType membership")
    }

    init{
        println("User created: $name with $membershipType membership")
    }
}

fun main(){
    val basicUser = User("John","john@doe.com")
    val premiumUser = User("Toubi","tubi@walmart.com","Premium")
}