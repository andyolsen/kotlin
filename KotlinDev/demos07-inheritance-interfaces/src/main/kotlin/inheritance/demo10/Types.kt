package inheritance.demo10

sealed class Equation

data class LinearEquation(val a: Int, val b: Int) : Equation()

data class QuadraticEquation(val a: Int, val b: Int, val c: Int) : Equation()

data class CubicEquation(val a: Int, val b: Int, val c: Int, val d: Int) : Equation()
