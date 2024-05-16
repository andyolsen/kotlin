package extensions

class StringExtensions(val isCaseSensitive: Boolean = false) {

    fun processStrings() {
        val s1 = "Swansea"
        println("$s1 has ${s1.countLettersCasey('S')} letter 's's")

        var s2: String? = null
        println("$s2 has ${s2.countLettersNullableCasey('S')} letter 's's")

        var s3: String? = "Abertawe"
        println("$s3 has ${s3.countLettersNullableCasey('a')} letter 'a's")

        var s4 = "Å"
        println("$s4 is a palindrome? ${s4.isPalindromeCasey}")

        var s5 = "wibble"
        s5.display()
    }

    fun String.countLettersCasey(letter: Char) : Int {
        val theLetter = if (isCaseSensitive) letter else letter.lowercase()
        val theString = if (isCaseSensitive) this else this.lowercase()

        var count = 0
        for (c in theString) {
            if (c == theLetter) {
                count++
            }
        }
        return count
    }

    fun String?.countLettersNullableCasey(letter: Char) : Int {
        return this?.countLettersCasey(letter) ?: 0
    }

    val String.isPalindromeCasey: Boolean
        get() {
            return if (isCaseSensitive) {
                this == this.reversed()
            } else {
                this.lowercase() == this.reversed().lowercase()
            }
        }

    fun String.display() : Unit {
        println("${this.toString()}")                   // Calls String's toString()
        println("${this@StringExtensions.toString()}")  // Calls StringExtensions' toString()
    }

    override fun toString(): String {
        return "StringExtensions(isCaseSensitive=$isCaseSensitive)"
    }
}

fun main() {

    val ext1 = StringExtensions()
    ext1.processStrings()

    println("----------------------------------------------------------------------------------")

    val ext2 = StringExtensions(true)
    ext2.processStrings()
}
