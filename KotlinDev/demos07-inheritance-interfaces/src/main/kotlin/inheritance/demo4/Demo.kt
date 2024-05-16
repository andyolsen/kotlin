package inheritance.demo4

open class BankAccount(var holder: String, var balance: Double) {

    override fun toString(): String {
        return "$holder, balance $balance"
    }
}

class SavingsAccount(holder: String, balance: Double, var interestRate: Double)
    : BankAccount(holder, balance) {

    override fun toString(): String {
        return "$holder, balance $balance, interest rate $interestRate"
    }
}

fun main() {
    var ba1 = BankAccount("Fred", 100.0)
    println(ba1)

    var sa1 = SavingsAccount("Wilma", 200.0, 2.0)
    println(sa1)
}