/*Лабораторная работа №4.
Тема: Указатели на функции в Kotlin:
Создать несколько функций с одинаковой сигнатурой. Создать массив указателей на эти функции. Вызвать их.
Создать несколько функций с разной сигнатурой. Создать массив указателей на эти функции. Вызвать их.
Создать несколько функций с разным количеством аргументов в сигнатуре. Создать массив указателей на эти функции. Вызвать их. (Исследовательская работа)
Создать три любых декоратора функции, применить (по одному и вместе), показать результат.
Создать декоратор функции с параметром (Исследовательская работа)*/

//Создать несколько функций с одинаковой сигнатурой. Создать массив указателей на эти функции. Вызвать их.
fun amout(numberOne:Int, numberTwo:Int):Int {
    return numberOne + numberTwo
}

fun multiplication(numberOne:Int, numberTwo:Int):Int {
    return numberOne * numberTwo
}

fun division(numberOne:Int, numberTwo:Int):Int {
    return numberOne / numberTwo
}

//Создать несколько функций с разной сигнатурой. Создать массив указателей на эти функции. Вызвать их.
fun print(text:String):String {
    return text
}

fun numberPrint(number:Int):Int {
    return number
}

fun floatPrint(number:Float):Float {
    return number
}

//Создать несколько функций с разным количеством аргументов в сигнатуре. Создать массив указателей на эти функции. Вызвать их. (Исследовательская работа)
fun amoutThree(numberOne:Int, numberTwo:Int, numberThree:Int):Int {
    return numberOne + numberTwo + numberThree
}

fun multiplicationOne(numberOne:Int):Int {
    return numberOne * 2
}

fun divisionTwo(numberOne:Int, numberTwo:Int):Int {
    return numberOne / numberTwo
}

//Создать три любых декоратора функции, применить (по одному и вместе), показать результат.
fun decoratorOneAmount(func: (Int, Int) -> Int): (Int, Int) -> Int {
    return fun(numberOne:Int, numberTwo:Int):Int {
        val result:Int = func(numberOne, numberTwo)
        print("Resul: , Hello world!")
        return result
    }
}

fun decoratorTwoAmount(func: (Int, Int) -> Int): (Int, Int) -> Int {
    return fun(numberOne:Int, numberTwo:Int):Int {
        val result:Int = func(numberOne, numberTwo)
        print("New: ")
        return result
    }
}

fun decoratorThreeAmount(func: (Int, Int) -> Int): (Int, Int) -> Int {
    return fun(numberOne:Int, numberTwo:Int):Int {
        val result:Int = func(numberOne, numberTwo)
        print("Type: ")
        return result
    }
}


fun main() {
    /*val arrayInt: Array<KFunction2<Int, Int, Int>> = arrayOf(::amout, ::multiplication, ::division)
    for (newFun in arrayInt) {
        println("Result: ${newFun(10, 2)}")
    }*/

   /* val arrayDifferentTypes: Array<KFunction1<*, Any>> = arrayOf(::print, ::numberPrint, ::floatPrint)
    for (newFun in arrayDifferentTypes) {
        when (newFun) {
            else -> {
                val result = when (newFun) {
                    ::print -> newFun.call("Hello")
                    ::numberPrint -> newFun.call(2)
                    ::floatPrint -> newFun.call(2.0f)
                    else -> {}
                }
                println("Result two: $result")
            }
        }
    }*/

/*    val arrayDifferentArguments: Array<KFunction<Int>> = arrayOf(::amoutThree, ::multiplicationOne, ::divisionTwo)
    println("ResultThree: ${arrayDifferentArguments[0].call(1, 2, 3)}")
    println("ResultThree: ${arrayDifferentArguments[1].call(3)}")
    println("ResultThree: ${arrayDifferentArguments[2].call(10, 2)}")*/

    var func_pointer: (Int, Int) -> Int = ::amout
    println("Default func: ${func_pointer(2, 3)}")

    func_pointer = decoratorOneAmount(::amout)
    println("Default func: ${func_pointer(2, 3)}")
}