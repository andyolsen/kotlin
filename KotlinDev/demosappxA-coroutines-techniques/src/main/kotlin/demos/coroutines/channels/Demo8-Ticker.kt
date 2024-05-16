package demos.coroutines.channels

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun main() = runBlocking {

    MyUtil.display("main starting a 1-sec ticker, initial delay 5sec")
    val tickerChannel = ticker(2000, 5000)

    val value1 = tickerChannel.receive()
    MyUtil.display("Received $value1")

    val value2 = tickerChannel.receive()
    MyUtil.display("Received $value2")

    val value3 = tickerChannel.receive()
    MyUtil.display("Received $value3")

    MyUtil.display("Let's do some work every 2secs")
    repeat(10) {
        tickerChannel.receive()
        MyUtil.display("Ho hum, doing work item $it")
    }

    tickerChannel.cancel()

    MyUtil.display("main says goodnight")
}
