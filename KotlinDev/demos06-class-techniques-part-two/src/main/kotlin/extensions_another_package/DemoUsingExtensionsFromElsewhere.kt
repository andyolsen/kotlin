package extensions_another_package

import extensions.*;

fun main() {

    val s1 = "swansea"
    println("$s1 has ${s1.countLetters('s')} letter 's's")

    var s2: String? = null
    println("$s2 has ${s2.countLettersNullable('s')} letter 's's")

    var s3: String? = "abertawe"
    println("$s3 has ${s3.countLettersNullable('a')} letter 'a's")

    var s4 = "Å"
    println("$s4 is a palindrome? ${s4.isPalindrome}")
}
