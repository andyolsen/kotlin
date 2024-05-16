package ex3

enum class EmploymentType {
    PERMANENT, CASUAL, CONTRACTOR
}

data class Employee(
    val name: String,
    val companyName: String,
    var salary: Double,
    var empType: EmploymentType = EmploymentType.PERMANENT
)

val Employee.taxStatus: String
    get() = when {
        salary < 20_000  -> "$name earns $salary [NO TAX PAYABLE]"
        salary < 40_000  -> "$name earns $salary [NORMAL-RATE TAX PAYABLE]"
        else             -> "$name earns $salary [HIGHER-RATE TAX PAYABLE]"
    }

fun main() {
    val emp1 = Employee("Matt", "Acme", 19999.0)
    val emp2 = Employee("Mark", "Acme", 20000.0)
    val emp3 = Employee("Luke", "Acme", 39999.0)
    val emp4 = Employee("John", "Acme", 40000.0)

    println(emp1.taxStatus)
    println(emp2.taxStatus)
    println(emp3.taxStatus)
    println(emp4.taxStatus)
}