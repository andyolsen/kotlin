package inheritanceAndGenerics

//--------------------------------------------------------------------------------------------------
// Consumer for each model class.
//--------------------------------------------------------------------------------------------------
class AConsumer : Consumer<A> {
    override fun consume(item: A) {
        println("In AConsumer with $item")
    }
}

class BConsumer : Consumer<B> {
    override fun consume(item: B) {
        println("In BConsumer with $item")
    }
}

class CConsumer : Consumer<C> {
    override fun consume(item: C) {
        println("In CConsumer with $item")
    }
}

fun main() {
    demoConsumerBisContravariant()
    demoConsumerCisContravariant()
}

fun demoConsumerBisContravariant() {
    // Consumer<B> is contravariant.
    // It means we can assign it a Consumer<B-or-superclass>.
    // See useBConsumer() below for an explanation of why this is allowed.
    val bConsumer1: Consumer<B> = BConsumer()
    val bConsumer2: Consumer<B> = AConsumer()

    // Let's create a B model object and consume it via our 2 B consumers.
    val bData = B()
    useBConsumer(bConsumer1, bData)
    useBConsumer(bConsumer2, bData)
}

// This func expects Consumer<B>. This is contravariant, so it could be Consumer<B-or-superclass>.
//   - If we passed in a Consumer<B>, consume() will expect B param.
//   - If we passed in a Consumer<A>, consume() will expect A param.
//  In each case, we pass in a B object which is OK (via Liskov).
fun useBConsumer(bConsumer : Consumer<B>, bData: B) {
    bConsumer.consume(bData)
}

fun demoConsumerCisContravariant() {
    // Consumer<C> is contravariant.
    // It means we can assign it a Consumer<C-or-superclass>.
    // See useCConsumer() below for an explanation of why this is allowed.
    val cConsumer1: Consumer<C> = CConsumer()
    val cConsumer2: Consumer<C> = AConsumer()

    // Let's create a C model object and consume it via our 2 C consumers.
    val cData = C()
    useCConsumer(cConsumer1, cData)
    useCConsumer(cConsumer2, cData)
}

// This func expects Consumer<C>. This is contravariant, so it could be Consumer<C-or-superclass>.
//   - If we passed in a Consumer<C>, consume() will expect C param.
//   - If we passed in a Consumer<A>, consume() will expect A param.
//  In each case, we pass in a C object which is OK (via Liskov).
fun useCConsumer(cConsumer : Consumer<C>, cData: C) {
    cConsumer.consume(cData)
}
