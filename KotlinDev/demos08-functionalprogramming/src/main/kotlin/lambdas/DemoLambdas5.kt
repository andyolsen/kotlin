package lambdas

typealias StringConsumer = (String) -> Unit

fun banner(start: String, end: String) : StringConsumer {
    val ts = java.time.LocalDateTime.now()
    return { msg -> println("$ts $start $msg $end") }
}

fun main() {
    val displayBannerFunc = banner("[---", "---]")

    displayBannerFunc("Hello")
    Thread.sleep(5000)
    displayBannerFunc("World")
}