package ex4

enum class EmploymentType {
    PERMANENT, CASUAL, CONTRACTOR
}

data class Employee(
    val name: String,
    val companyName: String,
    var salary: Double,
    var empType: EmploymentType = EmploymentType.PERMANENT
) : Comparable<Employee> {

    // emp1 + 1000
    operator fun plus(num: Double)  = this.copy(salary=salary+num)

    // emp1 - 100000000000000
    operator fun minus(num: Double) = this.copy(salary=salary-num)

    override fun compareTo(that: Employee) = when {
        this.salary < that.salary  -> -1
        this.salary > that.salary  -> +1
        else                       ->  0
    }
}

val Employee.taxStatus: String
    get() = when {
        salary < 20_000  -> "$name earns $salary [NO TAX PAYABLE]"
        salary < 40_000  -> "$name earns $salary [NORMAL-RATE TAX PAYABLE]"
        else             -> "$name earns $salary [HIGHER-RATE TAX PAYABLE]"
    }

fun main() {
    var emp1 = Employee("Matt", "Acme", 10000.0)
    emp1 = emp1 + 100.0
    emp1 = emp1 - 10.0
    emp1 += 200.0
    emp1 -= 20.0
    println(emp1)

    val emp2 = Employee("Lydia", "Example1Com", 20000.0)
    val emp3 = Employee("Peter", "Example2Com", 18000.0)
    println(emp2 > emp3)
    println(emp2 < emp3)
    println(emp2 >= emp3)
    println(emp2 <= emp3)
    println(emp2 == emp3)
    println(emp2 != emp3)
}