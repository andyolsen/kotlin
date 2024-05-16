package inheritanceAndGenerics

//--------------------------------------------------------------------------------------------------
// Define covariant, contravariant, and invariant generic types.
//--------------------------------------------------------------------------------------------------

// If T only appears in function outputs, qualify T with "out". We say T is covariant.
interface Producer<out T> {
    fun produce() : T
}

// If T only appears in function inputs, qualify T with "in". We say T is contravariant.
interface Consumer<in T> {
    fun consume(item: T)
}

// If T appears in function inputs and outputs, we can't use "in" or "out".
interface ProducerConsumer<T> {
    fun produce() : T
    fun consume(item: T)
}
