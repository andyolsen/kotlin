package ex3

import java.time.LocalDateTime
import java.util.*

class ID<T>(val id: T) {

    val timestamp = LocalDateTime.now()

    override fun toString(): String {
        return "[$id, $timestamp]"
    }
}

class ManagerException(msg: String) : Exception(msg)

class Employee(val employeeId: ID<UUID>, val name: String, var salary: Double) {

    var manager : Employee? = null
        set(value) {
            if (field == null)
                field = value
            else
                throw ManagerException("Already has a manager")
        }

    val hasManager
        get() = manager != null

    override fun toString(): String {
        return "$employeeId, $name, salary: $salary, hasManager: $hasManager"
    }
}

fun main() {

    val emp1 = Employee(ID(UUID.randomUUID()), "Ola", 10_000.0)
    println("Employee 1: $emp1")

    val emp2 = Employee(ID(UUID.randomUUID()), "Kari", 20_000.0)
    println("Employee 2: $emp2")

    val emp3 = Employee(ID(UUID.randomUUID()), "James", 1_000_000.0)
    println("Employee 3's manager initially: ${emp3.manager?.name ?: "Ikke i trafikk"}")
    emp3.manager = emp1
    println("Employee 3's manager afterward: ${emp3.manager?.name}")

    // This would cause a ManagerException:
    // emp3.manager = emp2
}