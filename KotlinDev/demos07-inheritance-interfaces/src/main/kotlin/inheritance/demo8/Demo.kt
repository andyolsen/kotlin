package inheritance.demo8

import java.lang.ClassCastException

open class BankAccount(var holder: String, var balance: Double) {

    override fun toString(): String {
        return "$holder, balance $balance"
    }

    open fun deposit(amount: Double) {
        balance += amount
    }

    open fun withdraw(amount: Double) {
        balance -= amount
    }

    open val status : String
        get() = when {
                balance <  0.0 -> "Overdrawn"
                balance == 0.0 -> "Empty"
                else           -> "In credit, so spend spend spend dude"
            }
}

class SavingsAccount(holder: String, balance: Double, var interestRate: Double)
    : BankAccount(holder, balance) {

    override fun toString(): String {
        return super.toString() + ", interest rate $interestRate"
    }

    override fun withdraw(amount: Double) {
        if (balance >= amount)
            super.withdraw(amount)
    }

    override val status: String
        get() = when {
            balance == 0.0 -> "Empty"
            else           -> "In credit, but spend wisely baby or you'll lose out on interest"
        }

    // New method.
    fun applyInterest() {
        val interestMultiplier = 1 + (interestRate/100)
        balance *= interestMultiplier
    }

    // New property.
    val isHighInterest : Boolean
        get() = interestRate > 1.0
}

fun main() {

    var ba1 = BankAccount("Fred", 100.0)
    processAccount(ba1)

    var sa1 = SavingsAccount("Wilma", 200.0, 2.0)
    processAccount(sa1)
}

fun processAccount(acc: BankAccount) {

    println("\nIn processAccount() with ${acc::class.simpleName}")

    // Use "is" to test for a subclass.
    if (acc is SavingsAccount) {
        println("Mate, you can earn interest on your SavingsAccount!")
    }

    // Once Kotlin knows the subclass type, you can use subclass members directly in the if-body.
    if (acc is SavingsAccount) {
        println("Dude, I'm going to give you interest.")
        acc.applyInterest()
    }

    // Once Kotlin knows the subclass type, you can use subclass members directly in the if-test.
    if (acc is SavingsAccount && acc.isHighInterest) {
        println("Babe, you're a high-interest earner, so here's some more interest.")
        acc.applyInterest()
    }

    // You can use "as" to do an unsafe typecast. Throws a ClassCastException if not that type.
    try {
        val sa = acc as SavingsAccount
        println("Chum, even more interest is inbound.")
        sa.applyInterest()
    }
    catch (ex: ClassCastException) {
        println("Whao, unsafe typecast failed: $ex")
    }

    println(acc)
}