package inheritanceAndGenerics

//--------------------------------------------------------------------------------------------------
// Producer for each model class.
//--------------------------------------------------------------------------------------------------
class AProducer : Producer<A> {
    override fun produce() : A {
        println("In AProducer")
        return A()
    }
}

class BProducer : Producer<B> {
    override fun produce() : B {
        println("In BProducer")
        return B()
    }
}

class CProducer : Producer<C> {
    override fun produce() : C {
        println("In CProducer")
        return C()
    }
}

fun main() {
    // Producer<A> is covariant.
    // It means we can assign it a Producer<A-or-subclass>.
    // See useProducer() below for an explanation of why this is allowed.
    val aProducer1: Producer<A> = AProducer()
    val aProducer2: Producer<A> = BProducer()
    val aProducer3: Producer<A> = CProducer()

    useProducer(aProducer1)
    useProducer(aProducer2)
    useProducer(aProducer3)
}

// This func expects Producer<A>. This is covariant, so it could be Producer<A-or-subclass>.
//   - If we passed in a Producer<A>, produce() will return A.
//   - If we passed in a Producer<B>, produce() will return B.
//   - If we passed in a Producer<C>, produce() will return C.
//  In each case, the return value can be assigned to A variable (via Liskov).
fun useProducer(aProducer : Producer<A>) {
    val item: A = aProducer.produce()
    println(item)
}
