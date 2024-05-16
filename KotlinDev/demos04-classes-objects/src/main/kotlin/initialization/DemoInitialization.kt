package initialization

import java.time.LocalDateTime

// Note we've omitted the constructor keyword here, for the primary constructor.
class BankAccount_ManualInit(name: String, id: Int, initBal: Double = 0.0) {
    var accountHolder = name
    var balance = initBal
    val id = id  // OK for property name and parameter name to be the same.
    val creationTimestamp = LocalDateTime.now()
}

class BankAccount(accountHolder: String,
                  val id: Int,
                  var balance: Double = 0.0)  {

    var accountHolder = ""
        set(value) {
            if (value.length > 60)
                throw Exception("eek")
            else
                accountHolder = value
        }

    init {
        this.accountHolder = accountHolder
        balance += 10.0
        println("Init block #1, generously credited with 10.0, balance is $balance")
    }

    // Define additional (non-parameterized) properties, if necessary.
    val creationTimestamp = LocalDateTime.now()

    init {
        balance -= 10.0
        println("Init block #2, cruelly took the 10.0 back, balance is $balance")
        println("Btw I can now tell you the creation timestamp: $creationTimestamp")
    }

    constructor(fname: String, lname: String, id: Int, balance: Double = 0.0)
            : this(fname + " " + lname, id, balance) {
        println("Greetings from secondary constructor!")
    }
}

fun main() {

    // Using primary constructors with manual initialization.
    val acc1 = BankAccount_ManualInit("Andy", 1, 100.0)
    val acc2 = BankAccount_ManualInit("Jayne", 2)

    // Using primary constructors with shorthand syntax.
    val acc3 = BankAccount("Andy", 1, 100.0)
    acc3.balance += 500
    println("${acc3.id} ${acc3.accountHolder}, balance ${acc3.balance}")

    // Example of implementing Primary Constructor Behaviour.
    val acc4 = BankAccount("Andy", 1, 100.0)

    // Using secondary constructors.
    var acc5 = BankAccount("Catherine", 1, 1000.0)   // Calls primary constructor
    var acc6 = BankAccount("Ed", "Lee", 2, 2000.0)   // Calls secondary constructor

}