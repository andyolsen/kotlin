package demos.coroutines.channels

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce

fun main() = runBlocking {

    val numbersChannel = produceNumbers()

    // Launch 5 asynchronous consumer coroutines ("fan-out").
    repeat(5) {
        launchSquareRootConsumer(it, numbersChannel)
    }
}

private fun CoroutineScope.produceNumbers(): ReceiveChannel<Int> = produce {
    for (n in 1..100) {
        send(n)
        delay(100)
    }
}

private fun CoroutineScope.launchSquareRootConsumer(id: Int, numbersChannel: ReceiveChannel<Int>) = launch {
    numbersChannel.consumeEach {
        delay((3000 * Math.random()).toLong())
        MyUtil.display("square-root-consumer[#$id] received $it, square root is ${Math.sqrt(it.toDouble())}")
    }
}
