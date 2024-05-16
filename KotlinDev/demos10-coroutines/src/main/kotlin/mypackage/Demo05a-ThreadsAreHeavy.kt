package mypackage

fun main() {

    // Start a lot of threads.
    repeat(100_000) {
        val t = Thread(Runnable {
            Thread.sleep(100L)
            val id = Thread.currentThread().id
            val count = Thread.activeCount()
            print("Thread id ${id}, active threads ${count}\n")
        })
        t.start()
    }
}