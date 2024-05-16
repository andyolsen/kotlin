package ex1

data class Employee(val id: Int, val name: String, val office: String, val salary: Double) : Comparable<Employee> {
    override fun compareTo(that: Employee) = salary.compareTo(that.salary)
    override fun toString() = "[$id] $name, $office, £$salary"
}

fun main() {

    val emps = listOf(
            Employee(1, "Peter Smith", "London", 25000.0),
            Employee(2, "Johan Mitra", "Bergen", 21000.0),
            Employee(3, "Diane Evans", "London", 32000.0),
            Employee(4, "Meera Jones", "Geneva", 2500000.0),
            Employee(5, "Gerry Lomax", "London", 7000.0),
            Employee(6, "Steff Holby", "Bergen", 55000.0),
            Employee(7, "Franz Elsom", "Bergen", 75000.0),
            Employee(8, "Simon Peter", "Geneva", 150000.0))

    println(emps)
}
