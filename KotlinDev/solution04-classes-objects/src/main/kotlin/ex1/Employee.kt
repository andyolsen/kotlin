package ex1

import java.time.LocalDateTime

class Employee (var name: String, var salary: Double) {

    constructor(name: String, basicSalary: Double, bonusPercentage: Double)
            : this(name, basicSalary * (1 + bonusPercentage / 100.0)) {
    }

    val joined = LocalDateTime.now()

    fun payRaise(amount: Double) {
        salary += amount
    }

    override fun toString() = "$name earns $salary and joined $joined"
}


fun main() {
    val emp1 = Employee ("John", 50000.0)
    val emp2 = Employee ("Mary", 100000.00, 5.0)
    emp1.payRaise(1000.0)
    println(emp1)
    println(emp2)
}
