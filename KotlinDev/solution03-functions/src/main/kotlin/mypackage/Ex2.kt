package mypackage

fun main() {

    // Declare variables for a hard-coded day, month, and year.
    val day = askUserForNumber("Please enter a day: ")
    val month = askUserForNumber("Please enter a month: ")
    val year = askUserForNumber("Please enter a year: ")

    val isLeapYearFlag = calcIsLeapYear(year)
    val daysInMonth = calcDaysInMonth(month, isLeapYearFlag)
    val monthName = calcMonthName(month)

    println("\nThe specified date is $day/$month/$year")

    println("\nHere are all the dates (in full format) in $month/$year")
    for (d in 1..daysInMonth) {
        println("  $d${calcSuffix(d)} $monthName $year")
    }
}

private fun askUserForNumber(prompt: String): Int {
    val scanner = java.util.Scanner(System.`in`)
    print(prompt)
    return scanner.nextInt()
}

private fun calcIsLeapYear(year: Int) = ((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)

private fun calcDaysInMonth(month: Int, isLeapYear: Boolean): Int {
    return when (month) {
        2 -> if (isLeapYear) 29 else 28
        4, 6, 9, 11-> 30
        else -> 31
    }
}

private fun calcMonthName(month: Int): String {
    return when(month) {
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
}

private fun calcSuffix(day: Int): String {
    return when(day) {
        1, 21, 31 -> "st"
        2, 22     -> "nd"
        3, 23     -> "rd"
        else      -> "th"
    }
}
