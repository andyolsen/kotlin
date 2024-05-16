package ex2

class ManagerException(msg: String) : Exception(msg)

class Employee(val name: String, var salary: Double) {

    var manager : Employee? = null
        set(value) {
            if (field == null)
                field = value
            else
                throw ManagerException("Already has a manager")
        }

    val hasManager
        get() = manager != null

    override fun toString(): String {
        return "$name, salary: $salary, hasManager: $hasManager"
    }
}

fun main() {

    val emp1 = Employee("Ola", 10_000.0)
    println("Employee 1: $emp1")

    val emp2 = Employee("Kari", 20_000.0)
    println("Employee 2: $emp2")

    val emp3 = Employee("James", 1_000_000.0)
    println("Employee 3's manager initially: ${emp3.manager?.name}")
    emp3.manager = emp1
    println("Employee 3's manager afterward: ${emp3.manager?.name}")

    try {
        emp3.manager = emp2
    }
    catch (ex: ManagerException) {
        println("Oops, exception..." + ex)
    }
}