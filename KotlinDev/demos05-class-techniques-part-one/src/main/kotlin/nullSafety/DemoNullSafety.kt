package nullSafety

import java.lang.NullPointerException
import java.util.*

fun main() {
    demoNullSafety()
    demoNullableTypes()
    demoAccessingMembersOnNullableVariable()
    demoSafeCallAndElvisOperators()
    demoSafeAssignment()
    demoCollectionOfNullable()
    demoCircumventingNullSafety()
}

fun demoNullSafety() {

    println("\ndemoNullSafety()----------------------------------------------------------")

    // Normal types cannot be assigned null.
    var s1: String = "Hei"

    // So you'll never ever ever get a NPE when you access members.
    println("s1 has length ${s1.length}")
}

fun demoNullableTypes() {

    println("\ndemoNullableTypes()-------------------------------------------------------")

    // If you want a variable to possibly be null, use syntax SomeType?
    var s1 : String? = "Bonjour"
    println(s1?.uppercase())

    // Can now assign null to variable.
    s1 = null
    println(s1)
}

fun demoAccessingMembersOnNullableVariable() {

    println("\ndemoAccessingMembersOnNullableVariable()----------------------------------")

    var s1 : String? = "Bonjour"

    // If you want to access members, you must ensure against null first.
    var len = if (s1 != null) s1.length else 0
    println("s1 has length $len")

    s1 = null;
    len = if (s1 != null) s1.length else 0
    println("s1 has length $len")

    // If you have an immutable variable and you test it's not null, you can then use freely.
    var s2 : String? = "Prynhawn da pawb"
    if (s2 != null) {
        // Kotlin allows us to use s2 freely here, cos it's definitely not null.
        println("s2 uppercase is ${s2.uppercase(Locale.getDefault())}")
        println("s2 lowercase is ${s2.lowercase()}")
    }
}

fun demoSafeCallAndElvisOperators() {

    println("\ndemoSafeCallAndElvisOperators()-------------------------------------------")

    var s1: String = "  Sawubona   "
    var s2: String? = null

    // You can use the safe call operator to access a member safely. Returns null if variable is null.
    println(s1?.length)
    println(s2?.length)

    // You can use the safe-call operator ?. in conjunction with the Elvis operator ?:
    // Returns expression on its left (if not null), else the expression on its right.
    val len = s1?.length ?: 0
    println(len)

    // The safe call operator is very handy if you have chained member access.
    println(s1.trim().reversed().lowercase())
    println(s2?.trim()?.reversed()?.lowercase())

    val s3 = f1(100)
    s3?.trim()
}

fun f1(n : Int) : String? {
    if (n == 0)
        return null
    else
        return "wibble"
}

class Car(var make: String, var model: String)
class Person(var name: String, var age: Int, var car: Car)

fun demoSafeAssignment() {

    println("\ndemoSafeAssignment()------------------------------------------------------")

    // You can use the safe call operator on the LHS of an assignment.
    // If one of the receivers is null, assignment is skipped and RHS expression is not evaluated.
    var p1: Person? = Person("Andy", 55, Car("Mazda", "6"))
    p1?.car?.model = "CX-30"
    println(p1?.car?.model)

    var p2: Person? = null
    p2?.car?.make = "Bugatti"
    println(p2?.car?.model)
}

fun demoCollectionOfNullable() {

    println("\ndemoCollectionOfNullable()------------------------------------------------")

    // Normal collections cannot contain nulls.
    // val list1 : List<String> = listOf("Huey", "Louis", "Dewey", null)

    // If you want the ability to contain nulls, do it like this:
    val list2 : List<String?> = listOf("Huey", "Louis", "Dewey", null)

    for (s in list2) {
        println("$s has length ${s?.length}")
    }
}

fun demoCircumventingNullSafety() {

    println("\ndemoCircumventingNullSafety()---------------------------------------------")

    var s : String? = null

    // Use the safe call operator to cater for null possibility, just returns null.
    println(s?.length)

    try {
        // Use the !! operator to circumvent Kotlin's null safety and throw an NPE, just like regular Java.
        println(s!!.length)
    }
    catch (ex: NullPointerException) {
        println("I knew this would happen: $ex")
    }
}