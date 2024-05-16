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

        // Close channel when done. This will enable receiver to know when to stop iterating.
        channel.close()
    }

    // Iterate over channel - gets next value, and stops iterating when channel is closed.
    for (receivedValue in channel) {
        MyUtil.display("Received from channel: $receivedValue")
    }
}