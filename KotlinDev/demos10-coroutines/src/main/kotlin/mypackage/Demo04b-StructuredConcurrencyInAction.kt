package mypackage

import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {

    MyUtil.display("MESSAGE A **************************************")

    runBlocking {
        launch {
            MyUtil.display("Child coroutine #1 - start")
            delay(5000L)
            MyUtil.display("Child coroutine #1 - end")
        }

        launch {
            MyUtil.display("Child coroutine #2 - start")
            delay(2000L)
            MyUtil.display("Child coroutine #2 - end")
        }
    }

    MyUtil.display("MESSAGE B **************************************")

    runBlocking {
        launch {
            MyUtil.display("Child coroutine #3 - start")
            delay(5000L)
            MyUtil.display("Child coroutine #3 - end")
        }

        launch {
            MyUtil.display("Child coroutine #4 - start")
            delay(2000L)
            MyUtil.display("Child coroutine #4 - end")
        }
    }

    MyUtil.display("MESSAGE C **************************************")
}
