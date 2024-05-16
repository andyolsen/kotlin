package ex2

enum class EmploymentType {
    PERMANENT, CASUAL, CONTRACTOR
}

data class Employee(
    val name: String,
    val companyName: String,
    var salary: Double,
    var empType: EmploymentType = EmploymentType.PERMANENT
)

fun main() {
    val emp1 = Employee("Matt", "Acme", 1000.0, EmploymentType.CONTRACTOR)
    emp1.empType = EmploymentType.PERMANENT
    println(emp1)
}