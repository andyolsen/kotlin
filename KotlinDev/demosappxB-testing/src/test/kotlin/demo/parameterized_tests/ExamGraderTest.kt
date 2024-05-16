package demo.parameterized_tests

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.api.Assertions.*

class ExamGraderTest {

    val examGrader = ExamGrader()

    @ParameterizedTest
    @MethodSource("markAndGradeProvider")
    fun testMarksAndGrades(mark: Int, grade: String) {
        assertEquals(grade, examGrader.getGradeForMark(mark))
    }

    // Note the call to Arguments.of() in the code below.
    // Arguments is an interface, and of() is a static method.
    // To be able to call a static method on an interface, you must set JVM version to 1.8 or above.
    // See pom.xml, where we configure the Kotlin Maven plugin to use jvmTarget=11.
    companion object {
        @JvmStatic
        fun markAndGradeProvider() = listOf(
            Arguments.of(99, "A*"),
            Arguments.of(70, "A"),
            Arguments.of(69, "B"),
            Arguments.of(60, "B"),
            Arguments.of(59, "C"),
            Arguments.of(50, "C"),
            Arguments.of(49, "D"),
            Arguments.of(40, "D"),
            Arguments.of(39, "E"),
            Arguments.of(30, "E"),
            Arguments.of(29, "U")
        )
    }
}
