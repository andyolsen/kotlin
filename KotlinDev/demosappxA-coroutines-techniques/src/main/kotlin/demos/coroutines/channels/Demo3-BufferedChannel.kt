package demos.coroutines.channels

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

fun main() = runBlocking {

    // Create a channel of Int (it's a bit like a blocking queue).
    val channel = Channel<Int>(10)

    launch {
        for (i in 1..20) {
            delay(500)  // Pretend we're doing something time-consuming to generate value.
            val valueToSend = i * i
            MyUtil.display("Sending to channel: $valueToSend")
            channel.send(i * i)
        }

        // Close channel when done. This will enable receiver to know when to stop iterating.
        channel.close()
    }

    // Iterate over channel - gets next value, and stops iterating when channel is closed.
    for (receivedValue in channel) {
        delay(2_000)  // Pretend we're doing something time-consuming to process value.
        MyUtil.display("Received from channel: $receivedValue")
    }
}