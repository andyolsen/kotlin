package classesInstances

import java.time.LocalDateTime

class BankAccount {

    val id = 0

    val creationTimestamp = LocalDateTime.now()
    var accountHolder = "Unknown"
    var balance = 0.0

    fun deposit(amount: Double) {
        balance += amount
        lastTransactionTimestamp = LocalDateTime.now()
    }

    fun withdraw(amount: Double) {
        balance -= amount
        lastTransactionTimestamp = LocalDateTime.now()
    }

    fun hasFunds(amount: Double) = balance >= amount

    override fun toString() = "$accountHolder $balance"

    val isOverdrawn: Boolean
        get() = this.balance < 0

    val isInCredit: Boolean
        get() = !isOverdrawn

    var field = "Unknown"
        set(value) {
            if (value.length < 60) field = value
        }

    var lastTransactionTimestamp = LocalDateTime.now()
        private set
}

fun main() {

    // Creating an instance and using simple properties.
    val acc1 = BankAccount()
    acc1.accountHolder = "Mary"
    acc1.balance += 500
    println("Account holder is ${acc1.accountHolder}, balance is ${acc1.balance}")

    // Calling methods.
    val acc2 = BankAccount()
    acc2.deposit(100.0)
    println("Has at least 200.0 in funds? ${acc2.hasFunds((200.0))}")

    // Using toString().
    val acc3 = BankAccount()
    acc3.accountHolder = "Andy"
    acc3.balance = 500.0
    println(acc3)   // Calls toString() implicitly

    // Using a custom getter.
    val acc4 = BankAccount()
    acc4.balance += 500
    println("Is account overdrawn? ${acc4.isInCredit}")

    // Using a custom setter.
    val acc5 = BankAccount()
    acc5.field = "Llanfairpwll"
    println("Branch location is ${acc5.field}")

    // Example of property visibility.
    val acc6 = BankAccount()
    acc6.deposit(100.0)
    println("Last transaction timestamp: ${acc6.lastTransactionTimestamp}")
}
