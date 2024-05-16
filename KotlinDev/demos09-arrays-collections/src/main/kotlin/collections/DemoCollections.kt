package collections

open class A(val value: Int)
open class B(value: Int) : A(value)
open class C(value: Int) : A(value)

fun main() {
    demoCollections()
    demoReadOnlyCollectionsAreCovariant()
    demoMutableCollectionsAreNotCovariant()
}

fun demoCollections() {

    // Create read-only list.
    val books = listOf("Matthew", "Mark", "Luke", "John")
    books.forEach{println(it)}

    // Create mutable list.
    val ukNations = mutableListOf("England", "Scotland", "Wales", "N Ireland")
    ukNations.remove("Scotland")
    ukNations.add("USA")
    ukNations -= "N Ireland"
    ukNations += "Singapore"
    ukNations.forEach{println(it)}
    ukNations.forEach{println(it)}

    // Create a read-only map (we could also create a mutable map, but you get the idea already).
    val diallingCodes = mapOf(Pair("UK", "+44"), Pair("Norway", "+47"), Pair("Singapore", "+65"), Pair("SA", "+27"))
    println(diallingCodes.size)

    // Create a read-only set (we could also create a mutable set, but life's too short).
    val decentWelshTeams = setOf("Swansea", "Newport", "Wrexham", "Swansea")
    println(decentWelshTeams.size)
}

fun demoReadOnlyCollectionsAreCovariant() {

    // Read-only collections are covariant, so Liskov Substitution Principle applies.
    val alist1 : List<A> = listOf<A>(A(100), A(200), A(300))
    val alist2 : List<A> = listOf<B>(B(400), B(500), B(600))
    val alist3 : List<A> = listOf<C>(C(700), C(800), C(900))
}

fun demoMutableCollectionsAreNotCovariant() {

    // Mutable collections are not covariant, so Liskov Substitution Principle doesn't apply.

    // This is OK...
    val alist1 : MutableList<A> = mutableListOf<A>()
    alist1.add(A(100))
    alist1.add(B(200))
    alist1.add(C(300))
    display(alist1)

    // This is not OK...
    // val alist2 : MutableList<A> = mutableListOf<B>()
    // alist2.add(A(400))
    // alist2.add(B(500))
    // alist2.add(C(600))

    // This is not OK...
    // val alist3 : MutableList<A> = mutableListOf<C>()
    // alist3.add(A(700))
    // alist3.add(B(800))
    // alist3.add(C(900))
}

fun display(list: List<A>) {
    for (item in list)
        println("${item::class.simpleName} value is ${item.value}")
}

