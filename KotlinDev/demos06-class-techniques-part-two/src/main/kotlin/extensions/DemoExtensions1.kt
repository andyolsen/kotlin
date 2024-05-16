package extensions

fun String.countLetters(letter: Char) : Int {
    var count = 0
    for (c in this) {
        if (c == letter) {
            count++
        }
    }
    return count
}

fun String?.countLettersNullable(letter: Char) : Int {
    return this?.countLetters(letter) ?: 0
}

val String.isPalindrome
    get() = this == this.reversed()

fun main() {
    demoSimpleExtension()
    demoNullableExtension()
    demoExtensionProperties()
}

fun demoSimpleExtension() {
    val s1 = "llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch"
    val gCount = s1.countLetters('g')
    println("That place has $gCount 'g's")
}

fun demoNullableExtension() {
    val s1 = "graiglwydd"
    var gCount = s1.countLettersNullable('g')
    println("s1 has $gCount 'g's")

    var s2: String? = null
    gCount = s2.countLettersNullable('g')
    println("s2 has $gCount 'g's initially")

    s2 = "grangemouth"
    gCount = s2.countLettersNullable('g')
    println("s2 has $gCount 'g's afterwards")
}

fun demoExtensionProperties() {
    val s1 = "kayak"
    println("Is $s1 a palindrome? ${s1.isPalindrome}")

    val s2 = "boatymcboatface"
    println("Is $s2 a palindrome? ${s2.isPalindrome}")
}