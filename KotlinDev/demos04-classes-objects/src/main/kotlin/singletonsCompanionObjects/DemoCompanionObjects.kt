package singletonsCompanionObjects

object Greeting {
    fun sayHello() {
        println("Hello")
    }
}

class MyClass(val id: Int) {

    companion object Factory {
        var nextId = 1
        fun create(): MyClass = MyClass(nextId++)
    }
}

class MyClassV2(val id: Int) {

    companion object {
        var nextId = 1
        fun create(): MyClassV2 = MyClassV2(nextId++)
    }
}

private class BankAccount(var accountHolder: String,
                          val id: Int,
                          var balance: Double = 0.0)  {

    fun withdraw(amount: Double) {
        if (balance - amount >= overdrawnLimit)
            balance -= amount
    }

    companion object {
        private val overdrawnLimit = -1000
    }
}

private class BankAccountV2(var accountHolder: String,
                            val id: Int,
                            var balance: Double = 0.0)  {

    fun withdraw(amount: Double) {
        if (balance - amount >= overdrawnLimit)
            balance -= amount
    }

    companion object {
        @JvmStatic
        private val overdrawnLimit = -1000
    }
}

fun main() {

    // Singletons.
    Greeting.sayHello()

    // Simple example of companion objects.
    val obj1 = MyClass.create()
    val obj2 = MyClass.create()
    println("${obj1.id} ${obj2.id}")

    // Accessing a companion object for a class.
    val companionObjForMyClass   = MyClass
    val companionObjForMyClassV2 = MyClassV2
    println("${MyClass.nextId} ${MyClassV2.nextId}")

    val acc1 = BankAccount("Andy", 1, 500.0)
    acc1.withdraw(1501.0)
    println("Balance is ${acc1.balance}")
}