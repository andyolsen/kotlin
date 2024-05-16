package mypackage

fun main() {

    // Loop through all the rows.
    for (r in 1..10) {

        // Print a row of stars before each row in the table.
        for (i in 1..62) {
            print("*")
        }
        println()

        // Loop through all the columns for the current row.
        for (c in 1..10) {

            // Calculate the number to print.
            val num = r * c

            // Print * followed by the appropriate amount of leading spaces (to right-align numbers nicely).
            print("* ")
            var tempNum = num
            while (tempNum < 100) {
                print(" ")
                tempNum *= 10
            }

            // Print the number followed by a trailing space.
            print("$num ")
        }

        // At the end of each row, print a trailing * and then a line-feed.
        println(" *")
    }

    // Print a row of stars after the final row in the table.
    for (i in 1..62) {
        print("*")
    }
}
