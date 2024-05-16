package ex3

import java.time.LocalDateTime

class Employee(var name: String, var salary: Double) {

    private val id = nextId

    companion object {
        var nextId = 1
            get() = field++
    }

    constructor(name: String, basicSalary: Double, bonusPercentage: Double)
            : this(name, basicSalary * (1 + bonusPercentage / 100.0)) {
    }

    val joined = LocalDateTime.now()

    var numberOfPayRises = -1

    fun payRaise(amount: Double) {
        salary += amount
        numberOfPayRises++
    }

    override fun toString() = "[$id] $name earns $salary and joined $joined"

    fun payBonus(percentRise: Double = 1.0) {
        salary *= (1 + percentRise/100.0)
    }

    fun payBonus(percentRise: Double, lowSalaryThreshold: Double, highSalaryThreshold: Double) {
        if (salary >= lowSalaryThreshold && salary <= highSalaryThreshold) {
            payBonus(percentRise)
        }
    }
}


fun main() {
    var emp = Employee("Mary", 25000.0)
    println("Emp details initially:   $emp")

    emp.payBonus()
    println("Emp after default bonus: $emp")

    emp.payBonus(10.0)
    println("Emp after 10% bonus:     $emp")

    emp.payBonus(10.0, 10000.0, 27000.0)
    println("Emp after bonus #3:      $emp")

    emp.payBonus(10.0, 10000.0, 30000.0)
    println("Emp after bonus #4:      $emp")
}
