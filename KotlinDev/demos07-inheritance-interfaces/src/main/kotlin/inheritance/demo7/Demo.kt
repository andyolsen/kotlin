package inheritance.demo7

open class BankAccount(var holder: String, var balance: Double) {

    override fun toString(): String {
        return "$holder, balance $balance}"
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
}

fun main() {

    // Liskov was right.
    var ba1 = BankAccount("Fred", 100.0)
    var sa1 = SavingsAccount("Wilma", 200.0, 2.0)
    var accs = listOf(ba1, sa1)

    // Process accounts polymorphically.
    processAccount(ba1)
    processAccount(sa1)
    accs.forEach({ a -> processAccount(a) })
}

fun processAccount(acc: BankAccount) {
    println("\nIn processAccount() with ${acc::class.simpleName}")
    acc.withdraw(500.0)
    println("acc balance: ${acc.balance}, status: ${acc.status}")
}