/* Лабораторная работа №3.
Тема: Функции в Kotlin Выполнить для предыдущего задания
(или использовать новый материал на свое усмотрение) следующие действия:*/
import kotlin.reflect.KFunction1

/*Создать три функции со следующими сигнатурами:
() -> Unit; (Any) -> Any; (Any) -> Collecions<Any>;*/
fun print(): Unit{
    println("Hello")
    return
}

/* (Any) -> Any*/
fun sum(number:Int): Int {
    return number + 10
}

/*(Any) -> Collecions<Any>*/
fun printList(size:Int): List<Int>{
    return List(size) { 10 }
}

/*Создать функцию с переменным количеством аргументов (vararg);*/
fun amount(vararg number:Int): IntArray {
    return number + 10
}

/*Создать функцию с параметрами по умолчанию;*/
fun multiplication(numberOne:Int = 2, numberTwo:Int = 2):Int{
    return numberOne * numberTwo
}

/*Создать функцию, аргументы которой можно передать только по имени;*/
fun delete(numberOne:Int, numberTwo:Int):Int{
    return numberOne / numberTwo
}

/*Создать функцию, которая в качестве аргумента принимает другую функцию;*/
fun prints(amount: KFunction1<Int, Int>): Int {
    val result = amount(1)
    return result
}

/*Создать функцию, которая в качестве возвращаемого
значения возвращает другую функцию;*/
fun printsFun(number:Int): Int {
    return sum(1)
}

/*Заменить один из циклов на рекурсивную функцию;*/
fun reqursia(number:Int):Int{
    return if (number == 1){
        1
    }
    else {
        number + reqursia(number - 1)
    }
}

fun main() {
    println(print())
    println(sum(1))
    println(amount(10))
    println(printList(4))
    println(multiplication())
    println(delete(numberOne = 8, numberTwo = 2))

    /*Три функции нужно представить в следующем виде -
    полноценное объявление функции (delete),
    анонимная функция (val sum = fun(x: Int, y: Int): Int = x + y println(sum)),
    лямбда-функция; (val sums = {x:Int, y:Int -> x + y} val result = sums(1, 6) println(result))*/
    //Анониная
    val sum = fun(x: Int, y: Int): Int = x + y
    println(sum)
    //Лямба
    val sums = {x:Int, y:Int -> x + y}
    val result = sums(1, 6)
    println(result)

    println(prints(::sum))
    println(printsFun(1))
    println(reqursia(12))
}