package demo.parameterized_tests

class ExamGrader {

    fun getGradeForMark(mark: Int) = when {
        mark >= 75 -> "A*"
        mark >= 70 -> "A"
        mark >= 60 -> "B"
        mark >= 50 -> "C"
        mark >= 40 -> "D"
        mark >= 30 -> "E"
        else       -> "U"
    }
}