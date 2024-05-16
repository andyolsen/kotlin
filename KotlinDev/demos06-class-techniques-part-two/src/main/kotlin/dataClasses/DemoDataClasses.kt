package dataClasses

import java.time.LocalDateTime

data class Person(var name: String, val nationality: String, var age: Int)

data class Employee(
    val id: Int,
    var name: String,
    var salary: Double,
    var joined: LocalDateTime = LocalDateTime.now()) {
}

fun main() {
    demoUsingDataClass()
    demoEquality()
    demoCopying()
    demoDestructuring()
    demoAdditionalProperties()
}

fun demoUsingDataClass() {

    val p1 = Person("Craig", "Welsh", 50)

    println("${p1.name} is ${p1.nationality} and is ${p1.age} years old")
    println(p1.toString())
    println(p1)  // Implicitly calls toString()
}

fun demoEquality() {

    var p1 = Person("Craig", "Welsh", 50)
    var p2 = Person("Craig", "Welsh", 50)

    val res1 = p1.equals(p2)    // Structural equality, returns true
    val res2 = p1 == p2         // == calls equals(), so this returns true too
    println("$res1, $res2")     // Prints true, true

    val res3 = p1 === p2        // === performs referential equality, returns false
    println("$res3")            // Prints false
}

fun demoCopying() {

    var p1 = Person("Andy", "Welsh", 55)

    var p2 = p1.copy()
    println(p2)   // Andy, Welsh, 55

    var p3 = p1.copy(name="Jayne")
    println(p3)   // Jayne, Welsh, 55
}

fun demoDestructuring() {

    var p1 = Person("Andy", "Welsh", 55)

    // Destructure all fields implicitly via componentN() functions.
    val (nameA, natA, ageA) = p1
    println("Hey $nameA, you're $natA and you'll soon be ${ageA+1}")

    // The above code is actually compiled into code like this.
    val nameB = p1.component1()
    val natB  = p1.component2()
    val ageB  = p1.component3()
    println("Hey $nameB, you're still $natB but you're not still ${ageB-1}")

    // You can destructure a subset of properties (in order of ctor params).
    val (nameC, natC) = p1
    println("Hey $nameC baby, I love it you're still $natC")

    // You can skip properties via _.
    val (nameD, _, ageD) = p1
    println("Hey $nameD dude, you're ${100-ageD} years from a telegram from Her Majesty")
}

fun demoAdditionalProperties() {

    var e1 = Employee(1, "Andy", 1000.0)

    println(e1)              // Just prints props defined in primary ctor.

    var e2 = e1.copy()       // Just copies props defined in primary ctor.
    println(e2)

    Thread.sleep(5000)
    var e3 = Employee(1, "Andy", 1000.0)
    println(e3.equals(e2))   // Just compares props defined in primary ctor.

    val (id, n, s) = e3      // Just destructures props defined in primary ctor.
    println("$id, $n, $s")

    println("${e3.name} joined ${e3.joined}")  // Can access additional property like this.
}
