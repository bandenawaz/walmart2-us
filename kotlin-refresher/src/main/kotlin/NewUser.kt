data class NewUser(val name: String, val email: String, val membershipType: String = "Basic")


fun main(){
    val user = NewUser("John","john@doe.com")
    println(user)
    val user2 = NewUser("James","james@doe.com","Premium")
    println(user2)

    println(user.copy(membershipType = "Premium"))
}
