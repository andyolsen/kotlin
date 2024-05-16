package inheritance.demo6

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

class SavingsAccount(
    holder: String,
    balance: Double,
    var interestRate: Double) : BankAccount(holder, balance) {

    override fun toString(): String {
        return super.toString() + ", interest rate $interestRate"
    }

    override fun withdraw(amount: Double) {
        if (balance >= amount)
            super.withdraw(amount)
    }

    override val status : String
        get() = when {
            balance == 0.0 -> "Empty"
            else           -> "In credit, but spend wisely baby or you'll lose out on interest"
        }
}

fun main() {

    var ba1 = BankAccount("Fred", 100.0)
    ba1.withdraw(500.0)
    println("ba1 balance: ${ba1.balance}, status: ${ba1.status}")

    var sa1 = SavingsAccount("Wilma", 200.0, 2.0)
    sa1.withdraw(500.0)
    println("sa1 balance: ${sa1.balance}, status: ${sa1.status}")
}