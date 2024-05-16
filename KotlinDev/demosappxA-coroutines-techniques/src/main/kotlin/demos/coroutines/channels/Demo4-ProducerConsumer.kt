package demos.coroutines.channels

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce

fun main() = runBlocking {

    MyUtil.display("Consuming items from produceSquares1() producer")
    var channel = produceSquares1()
    for (receivedValue in channel) {
        MyUtil.display("Received from channel: $receivedValue")
        delay(2_000)  // Pretend we're doing something time-consuming work.
    }

    MyUtil.display("Consuming items from produceSquares2() producer")
    channel = produceSquares2()
    for (receivedValue in channel) {
        MyUtil.display("Received from channel: $receivedValue")
        delay(2_000)  // Pretend we're doing something time-consuming work.
    }

    MyUtil.display("Consuming items from produceSquares3() producer, using consumeEach() extension function")
    channel = produceSquares3()
    channel.consumeEach {
        MyUtil.display("Received from channel: $it")
        delay(2_000)  // Pretend we're doing something time-consuming work.
    }
}

private fun CoroutineScope.produceSquares1(): ReceiveChannel<Int> {

    val channel: ReceiveChannel<Int> = produce {
        for (i in 1..10) {
            delay(500)  // Pretend we're doing something time-consuming to generate a value.
            val valueToSend = i * i
            MyUtil.display("Sending to channel: $valueToSend")
            send(valueToSend)
        }
    }
    return channel
}

private fun CoroutineScope.produceSquares2(): ReceiveChannel<Int> = produce {
    for (i in 1..10) {
        delay(500)  // Pretend we're doing something time-consuming to generate a value.
        val valueToSend = i * i
        MyUtil.display("Sending to channel: $valueToSend")
        send(valueToSend)
    }
}

private fun CoroutineScope.produceSquares3(): ReceiveChannel<Int> = produce(capacity=10) {
    for (i in 1..10) {
        delay(500)  // Pretend we're doing something time-consuming to generate a value.
        val valueToSend = i * i
        MyUtil.display("Sending to channel: $valueToSend")
        send(valueToSend)
    }
}
