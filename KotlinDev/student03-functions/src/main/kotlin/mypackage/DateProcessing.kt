package mypackage

fun main() {

    // Declare variables for a hard-coded day, month, and year.
    val day = 3
    val month = 12
    val year = 2023

    // Determine if it's a leapyear.
    val isLeapYearFlag = ((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)

    // Determine the number of days in the month.
    val daysInMonth = when (month) {
        2 -> if (isLeapYearFlag) 29 else 28
        4, 6, 9, 11-> 30
        else -> 31
    }

    // Determine the name of the month.
    val monthName = when(month) {
        1  -> "January"
        2  -> "February"
        3  -> "March"
        4  -> "April"
        5  -> "May"
        6  -> "June"
        7  -> "July"
        8  -> "August"
        9  -> "September"
        10 -> "October"
        11 -> "November"
        12 -> "December"
        else -> "Not Known"    // Should never happen
    }

    println("\nThe specified date is $day/$month/$year")

    println("\nHere are all the dates (in full format) in $month/$year")
    for (d in 1..daysInMonth) {
        val suffix = when(d) {
            1, 21, 31 -> "st"
            2, 22     -> "nd"
            3, 23     -> "rd"
            else      -> "th"
        }
        println("  $d$suffix $monthName $year")
    }
}