package inheritance.demo10b

import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

// This example demonstrates serialization of sealed classes.
// Also see build.gradle.kts, in the "dependencies" and "plugins" sections.

fun main() {
    demoSerializationDeserialization(LinearEquation(1, 2))
    demoSerializationDeserialization(QuadraticEquation(1, 2, 3))
    demoSerializationDeserialization(CubicEquation(1, 2, 3, 4))
}

// You want Kotlin to use polymorphic serialization, whereby a "type" property is serialized
// so that it knows what exact type to deserialize later.
// In order to achieve polymorphic serialization, you MUST declare your variable as a "base" type
// rather than as a "derived" type.
fun demoSerializationDeserialization(eq: Equation)  {

    // Serialize some object in the Equation hierarchy.
    // Note: The serializer will also serialize a "type" discriminator field.
    val jsonString = Json.encodeToString(eq)
    println("\nJSON string: $jsonString")

    // Deserialize the string into something in the Equation hierarchy.
    // Note: The deserializer will use the "type" discriminator field to deduce the exact type to instantiate.
    val obj = Json.decodeFromString<Equation>(jsonString)
    println("Object: $obj")
}