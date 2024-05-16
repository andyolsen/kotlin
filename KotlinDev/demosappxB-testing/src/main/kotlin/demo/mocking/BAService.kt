package demo.mocking

class BAService(val repos: BARepository, val logger: Logger) {

    fun depositIntoAccount(id: Int, amount: Int) {
        val acc = repos.getById(id)
        acc.deposit(amount)
        repos.update(id, acc)
        logger.log("Account $id, deposited GBP$amount")
    }

    fun getBalanceForAccount(id: Int) = repos.getById(id).balance

    fun getBalanceForAccounts(vararg ids: Int): Int {
        var total = 0
        for (id in ids) {
            total += getBalanceForAccount(id)
        }
        return total
    }
}