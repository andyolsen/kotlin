package demos.coroutines.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object MyUtil {
    fun display(message: String) {
        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSSS")
        val timestamp = LocalDateTime.now().format(formatter)
        println("[$timestamp] [Thread id ${Thread.currentThread().id}, name ${Thread.currentThread().name}] $message")
    }
}