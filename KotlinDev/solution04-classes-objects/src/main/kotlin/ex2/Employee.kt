package ex2

import java.time.LocalDateTime

class Employee (var name: String, var salary: Double) {

    private val id = nextId

    companion object {
        var nextId = 1
            get() = field++
    }

    constructor(name: String, basicSalary: Double, bonusPercentage: Double)
            : this(name, basicSalary * (1 + bonusPercentage / 100.0)) {
    }

    val joined = LocalDateTime.now()

    fun payRaise(amount: Double) {
        salary += amount
    }

    override fun toString() = "[$id] $name earns $salary and joined $joined"
}


fun main() {
    val emp1 = Employee ("Matt", 100000.0)
    val emp2 = Employee ("Mark", 200000.00)
    val emp3 = Employee ("Luke", 300000.00)
    val emp4 = Employee ("John", 400000.00, 5.0)
    println(emp1)
    println(emp2)
    println(emp3)
    println(emp4)
}
