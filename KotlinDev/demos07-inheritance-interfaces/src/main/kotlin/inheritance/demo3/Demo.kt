package inheritance.demo3

open class BankAccount(var holder: String, var balance: Double)

class SavingsAccount(holder: String, balance: Double, var interestRate: Double)
    : BankAccount(holder, balance)

fun main() {
    var ba1 = BankAccount("Fred", 100.0)
    println(ba1)

    var sa1 = SavingsAccount("Wilma", 200.0, 2.0)
    println(sa1)
}