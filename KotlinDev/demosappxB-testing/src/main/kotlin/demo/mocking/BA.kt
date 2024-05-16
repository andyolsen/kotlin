package demo.mocking

class BA(val id: Int?, val name: String, var balance: Int = 0) {

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
        return "[$id] $name, balance $balance";
    }
}