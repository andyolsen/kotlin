package demos.coroutines.channels

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun main() = runBlocking {

    val numbersChannel = Channel<Int>()

    // Launch 5 asynchronous producer coroutines.
    repeat(5) {
        launchNumbersProducer(it, it, numbersChannel)
    }

    // Consume the values produced by the 5 asynchronous producer coroutines in a single consumer ("fan-in")
    numbersChannel.consumeEach {
        MyUtil.display("\t\t\t\t\t\t\t\t\tmain received $it")
    }

    MyUtil.display("main says goodbye")
}

private fun CoroutineScope.launchNumbersProducer(id: Int, powerOfTen: Int, numbersChannel: SendChannel<Int>) = launch {

    val multiplier = Math.pow(10.0, powerOfTen.toDouble()).toInt()
    for (n in 1..10) {

        delay((3000 * Math.random()).toLong())

        if (numbersChannel.isClosedForSend) {
            break;
        }
        else {
            val valueToSend = n * multiplier
            MyUtil.display("numbers-producer[#$id] sending $valueToSend")
            numbersChannel.send(valueToSend)
        }
    }

    MyUtil.display("numbers-producer[#$id] finished------------------------------------------------------------------")
    numbersChannel.close()
}