package demo.unit_testing

class BankAccount(val name: String, var balance: Int = 0) {

    fun deposit(amount: Int): Int {
        balance += amount
        return balance
    }

    fun withdraw(amount: Int): Int {
        require(amount <= balance) { "Insufficient funds" }
        balance -= amount
        return balance
    }

    override fun toString(): String {
        return "$name, balance $balance";
    }
}