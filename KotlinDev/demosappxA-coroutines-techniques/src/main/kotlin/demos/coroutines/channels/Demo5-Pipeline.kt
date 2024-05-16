package demos.coroutines.channels

import demos.coroutines.utils.MyUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce

fun main() = runBlocking {

    MyUtil.display("Setting up pipeline-------------------------------------------------")
    val numbersChannel = produceNumbers()
    val squareRootsChannel = squareRoot(numbersChannel)
    val stringsChannel = toString2dp(squareRootsChannel)
    stringsChannel.consumeEach {
        MyUtil.display("main received $it")
    }

    MyUtil.display("Setting up pipeline using shorter syntax----------------------------")
    toString2dp(squareRoot(produceNumbers())).consumeEach {
        MyUtil.display("main received $it")
    }

    MyUtil.display("main says goodbye")
}

private fun CoroutineScope.produceNumbers(): ReceiveChannel<Int> = produce {
    for (n in 1..5) {
        delay(5_000)
        MyUtil.display("produceNumbers sending $n")
        send(n)
    }
}

private fun CoroutineScope.squareRoot(numbersChannel: ReceiveChannel<Int>): ReceiveChannel<Double> = produce {
    for (n in numbersChannel) {
        delay(500)
        val valueToSend = Math.sqrt(n.toDouble())
        MyUtil.display("squareRoot sending $valueToSend")
        send(valueToSend)
    }
}

private fun CoroutineScope.toString2dp(fractionsChannel: ReceiveChannel<Double>): ReceiveChannel<String> = produce {
    for (n in fractionsChannel) {
        delay(500)
        val valueToSend = "%.2f".format(n)
        MyUtil.display("toString2dp sending $valueToSend")
        send(valueToSend)
    }
}