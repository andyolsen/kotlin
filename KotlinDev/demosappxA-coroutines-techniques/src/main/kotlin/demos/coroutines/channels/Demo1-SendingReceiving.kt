package demos.coroutines.channels

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

fun main() = runBlocking {

    // Create a channel of Int (it's a bit like a blocking queue).
    val channel = Channel<Int>()

    launch {
        for (i in 1..5) {
            delay(3_000)  // Pretend we're doing something time-consuming to generate a value.

            val valueToSend = i * i
            MyUtil.display("Sending to channel: $valueToSend")
            channel.send(i * i)
        }
    }

    // Receive values from the channel (one at a time).
    repeat(5) {
        val receivedValue = channel.receive()
        MyUtil.display("Received from channel: $receivedValue")
    }
}