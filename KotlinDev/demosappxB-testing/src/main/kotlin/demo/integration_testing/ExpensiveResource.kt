package demo.integration_testing

class ExpensiveResource {
    
    var count = 0

    constructor() {
        println("Creating expensive resource")
        Thread.sleep(5_000)
        println("Created expensive resource")
    }
}