package ex4

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

    // Invoke functions.
    displayEmployeeFullDetails(emps)
    displayEmployeeNames(emps)
    displayWageBill(emps)
    displaySortedDistinctOffices(emps)
    displayEmployeesSortedBySalary(emps)
}

fun displayEmployeeFullDetails(emps: List<Employee>) {
    println("\nFull details of all employees")
    println("--------------------------------------------------------------")
    emps.forEach{println(it)}
}

fun displayEmployeeNames(emps: List<Employee>) {
    println("\nNames of all employees")
    println("--------------------------------------------------------------")
    emps.forEach{println(it.name)}
}

fun displayWageBill(emps: List<Employee>) {
    val wageBill = emps.map{it.salary}.sum()
    println("\nTotal wage bill: £$wageBill")
    println("--------------------------------------------------------------")
}

fun displaySortedDistinctOffices(emps: List<Employee>) {

    println("\nDistinct offices (alphabetic order)")
    println("--------------------------------------------------------------")

    emps.
        map{it.office}.
        distinct().
        sorted().
        forEach{println(it)}
}

fun displayEmployeesSortedBySalary(emps: List<Employee>) {

    println("\nEmployees sorted by descending salary")
    println("--------------------------------------------------------------")

    emps.
        sortedByDescending{it.salary}.
        forEach{println(it)}
}

