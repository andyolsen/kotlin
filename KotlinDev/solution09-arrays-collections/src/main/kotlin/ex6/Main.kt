package ex6

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

    val predGenevaOffice: Predicate = {emp -> emp.office == "Geneva"}
    val predHighlyPaid: Predicate   = {emp -> emp.salary >= 50000}
    displayFilteredEmployees("Geneva employees", emps, predGenevaOffice)
    displayFilteredEmployees("Highly paid employees", emps, predHighlyPaid)
    displayFilteredEmployees("Highly paid employees in Geneva", emps){predHighlyPaid(it) && predGenevaOffice(it)}

    displaySalaryStats(emps)
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

typealias Predicate = (Employee) -> Boolean

fun displayFilteredEmployees(message: String, emps: List<Employee>, predicate: Predicate) {

    println("\n$message")
    println("--------------------------------------------------------------")

    emps.
        filter(predicate).
        forEach{println(it)}
}

fun displaySalaryStats(emps: List<Employee>) {

    println("\nSalary statistics")
    println("--------------------------------------------------------------")

    val min = emps.map{it.salary}.minOrNull()
    println("Minimum salary of all employees: £$min")

    val max = emps.map{it.salary}.maxOrNull()
    println("Maximum salary of all employees: £$max")

    println("Top 5 employees by salary [descending]:")
    emps.sortedByDescending{it.salary}.
         take(5).
         forEach{println("    $it")}

    println("\nTop 5 employees by name [ascending]:")
    emps.sortedBy{it.name}.
         take(5).
         forEach{println("    $it")}
}