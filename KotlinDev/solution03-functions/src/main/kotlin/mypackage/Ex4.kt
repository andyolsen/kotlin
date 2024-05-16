package mypackage

fun main() {

    val faveNum = askUserForNumber("Before we get started old bean, might I enquire what is your all-time fave number? ")
    println("What an amazing coincidence, $faveNum is my favourite number too. Spooky!!!\n")

    val month = askUserForNumber("Please enter a month:", 1, 12)
    val year = askUserForNumber("Please enter a year:", 0, 2099)

    val isLeapYearFlag = calcIsLeapYear(year)
    val daysInMonth = calcDaysInMonth(month, isLeapYearFlag)
    val monthName = calcMonthName(month)

    val day = askUserForNumber("Please enter a day:", 1, daysInMonth)

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

private fun askUserForNumber(prompt: String, min: Int, max: Int): Int {
    val fullPromptMessage = "$prompt [min $min, max $max]: "
    var num : Int

    do {
        num = askUserForNumber(fullPromptMessage)
    } while (num < min || num > max)

    return num
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
