package inheritance.demo10b

import kotlinx.serialization.Serializable

// To support serialization, all types must be annotated with @Serializable.
// This is a Kotlin API, so it works on Kotlin/JVM and Kotlin/Native.

// Aside: If you want to serialize an "open" hierarchy, i.e. with open rather than sealed inheritance,
// it's a bit more complicated. You have to register what types need to be serialized/deserialized.
// For details, see https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/polymorphism.md#open-polymorphism

@Serializable
sealed class Equation

@Serializable
data class LinearEquation(val a: Int, val b: Int) : Equation()

@Serializable
data class QuadraticEquation(val a: Int, val b: Int, val c: Int) : Equation()

@Serializable
data class CubicEquation(val a: Int, val b: Int, val c: Int, val d: Int) : Equation()
