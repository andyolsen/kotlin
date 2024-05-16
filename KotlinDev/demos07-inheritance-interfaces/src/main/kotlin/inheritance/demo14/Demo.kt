package inheritance.demo14

interface ParentInterface {
    fun m1(i: Int)
    fun m2(d: Double)
    fun m3(s: String) {
        println("ParentInterface.m3 received $s")
    }
}

//----------------------------------------------------------------------------------------
// Special case 1.
//----------------------------------------------------------------------------------------
class ChildClass : ParentInterface {
    // Normal stuff in a class...

    // Must override m1().
    override fun m1(i: Int) {
        println("ChildClass.m1 received $i")
    }

    // Must override m2().
    override fun m2(d: Double) {
        println("ChildClass.m2 received $d")
    }

    // Optionally, can override m3(), and invoke interface's implementation (if we like).
    override fun m3(s: String) {
        println("ChildClass.m3 received $s")
        super.m3(s)
    }
}

// ----------------------------------------------------------------------------------------
// Special case 2.
//----------------------------------------------------------------------------------------
interface MyInterface {
    fun m1()
    fun m2()
    fun m3() {
        println("MyInterface.m3")
    }
}

open class MyClass {
    fun mA() {
        println("MyClass.mA")
    }

    fun mB() {
        println("MyClass.mB")
    }

    open fun m3() {
        println("MyClass.m3")
    }
}

class MyOtherClass : MyClass(), MyInterface {
    override fun m1() {
        println("MyOtherClass.m1")
    }

    override fun m2() {
        println("MyOtherClass.m2")
    }

    // Inherits concrete MyInterface.m3() and MyClass.m3().
    // In Java, the class version of m3() would take priority.
    // In Kotlin, there's no priority, so you must override it here.
    override fun m3() {
        println("MyOtherClass.m3")

        // Can optionally call interface version and/or superclass version too.
        super<MyInterface>.m3()
        super<MyClass>.m3()
    }
}

//----------------------------------------------------------------------------------------
// Special case 3.
//----------------------------------------------------------------------------------------
interface MyInterface1 {
    fun m1()
    fun m2()
    fun m3() {
        println("MyInterface1.m3")
    }
}

interface MyInterface2 {
    fun mA()
    fun mB()
    fun m3() {
        println("MyInterface2.m3")
    }
}

class MyAnotherClass : MyInterface1, MyInterface2 {
    override fun m1() {
        println("MyAnotherClass.m1")
    }

    override fun m2() {
        println("MyAnotherClass.m2")
    }

    override fun mA() {
        println("MyAnotherClass.mA")
    }

    override fun mB() {
        println("MyAnotherClass.mB")
    }

    // If you comment-out the following implementation of m3(), you'll get a compiler error
    // because this class inherits multiple concrete m3() implementations.
    override fun m3() {
        println("MyAnotherClass.m3")

        // Can optionally call interface version and/or superclass version too.
        super<MyInterface1>.m3()
        super<MyInterface2>.m3()
    }
}

fun main() {
    val obj = ChildClass()
    obj.m1(42)
    obj.m2(3.14)
    obj.m3("banana")

    val otherObj = MyOtherClass()
    otherObj.m3()

    val anotherObj = MyAnotherClass()
    anotherObj.m3()
}