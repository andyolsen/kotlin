package ex1

data class Employee(val name: String, val companyName: String, var salary: Double)

fun main() {

    val emp1 = Employee("Matt", "Acme", 1000.0)
    emp1.salary *= 2
    // emp1.name = "Matthew"
    // emp1.companyName = "JetBrains"
    println("${emp1.name} works for ${emp1.companyName} and earns ${emp1.salary}")

    val emp2 = Employee("Matt", "Acme", 2000.0)
    println("Is emp1 == emp2? ${emp1 == emp2}")
    println("Is emp1.equals(emp2)? ${emp1.equals(emp2)}")

    val emp3 = emp1.copy(salary = 1100.0)
    val (n, _, s) = emp3
    println("$n earns $s")
}
