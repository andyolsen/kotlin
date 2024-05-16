package collections

import java.util.*

fun main() {
    demoForEach()
    demoFilter()
    demoMap()
    demoFlatMap()
    demoFold()
    demoReduce()
    demoGroupBy()
}

fun demoForEach() {

    println("\ndemoForEach()-----------------------------------------------------------------------------")

    val cities = listOf("Oslo", "Budapest", "Singapore", "Cape Town")

    cities.forEach{
        println(it.uppercase(Locale.getDefault()))
    }
}

fun demoFilter() {

    println("\ndemoFilter()------------------------------------------------------------------------------")

    val cities = listOf("Stavanger", "Budapest", "Singapore", "Swansea")
    println(cities)

    val citiesStartingWithS = cities.filter{it.startsWith("S")}
    println(citiesStartingWithS)
}


fun demoMap() {

    println("\ndemoMap()---------------------------------------------------------------------------------")

    data class City(val name: String, val population: ULong)

    val cities = listOf(City("Stavanger", 121000UL),
                        City("Budapest", 1800000UL),
                        City("Singapore", 5600000UL)
    )

    val pops = cities.map{it.population}
    println(pops)
}

fun demoFlatMap() {

    println("\ndemoFlatMap()-----------------------------------------------------------------------------")

    data class City(val name: String, val landmarks: List<String>)

    val cities = listOf(City("Singapore", listOf("Merlion", "Sentosa")),
                        City("Budapest",  listOf("Castle", "Chain Bridge")),
                        City("Stavanger", listOf("Priekestolen", "Møllebukta")))

    val landmarks = cities.map{it.landmarks}
    val landmarksFlatMap = cities.flatMap{it.landmarks}

    println(landmarks)
    println(landmarksFlatMap)
}

fun demoFold() {

    println("\ndemoFold()--------------------------------------------------------------------------------")

    val cities = listOf("Stavanger", "Budapest", "Singapore")

    val str = cities.fold("RESULT:") { a, c -> "$a $c" }
    println(str)
}

fun demoReduce() {

    println("\ndemoReduce()------------------------------------------------------------------------------")

    val cities = listOf("Stavanger", "Budapest", "Singapore")

    val str = cities.reduce{ a, c -> "$a $c" }
    println(str)
}

fun demoGroupBy() {

    println("\ndemoGroupBy()----------------------------------------------------------------------")

    data class City(val name: String, val pop: Long, val country: String)

    val cities = listOf(City("Oslo", 580000, "Norway"),
                        City("Cape Town", 3433441, "SA"),
                        City("Durban", 3120282, "SA"),
                        City("Bergen", 213585, "Norway"),
                        City("Trondheim", 147139, "Norway"),
                        City("Joburg", 2026469, "SA"))

    val groupedCities = cities.groupBy{it.country}
    println(groupedCities)
}