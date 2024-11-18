/*Лабораторная работа №8
Тема: Аннотации Kotlin
1. Применить несколько аннотаций из стандартной библиотеки Kotlin;
2. Применить несколько аннотаций из стандартной библиотеки Java;
3. Создать не менее трёх своих аннотаций;
4. Написать код, который по аннотациям изменяет функциональность кода.*/

//1. Применить несколько аннотаций из стандартной библиотеки Kotlin;
@Target
@Retention
@Repeatable
annotation class Food(val name:String, val expirationDate:String)

//2. Применить несколько аннотаций из стандартной библиотеки Java;
@Deprecated("Этот класс устарел")
@Retention
annotation class Student(val name:String, val age:Int)

annotation class Override
open class ParentClass {
    fun getName():String = "Hi"
}

class ChildClass: ParentClass() {
    @Override
    fun getname():String = "Hello"
}

//3. Создать не менее трёх своих аннотаций;
annotation class Inject
class Foo @Inject constructor(var student:Student) { }

annotation class Color(val color: String)
//@Color("RED") class Printsis {}

annotation class JsonProperty(val value: String)
data class SomeData(@JsonProperty("id") val someDataId: String)

//4. Написать код, который по аннотациям изменяет функциональность кода.
@Color("RED")
class Printsis {
    fun printMessage() {
        println("Printing a message from Printsis.")
    }
}

fun main() {
    val a = Printsis()
    a.printMessage()
}