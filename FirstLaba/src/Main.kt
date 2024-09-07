/*Лабораторная работа № 1.
Базовое владение языком kotlin.
Выполнить каждое задание в группе ниже по варианту в виде отдельной функции.
*/

/*Тема: Условия и циклы.
Каждый вариант должен демонстрировать все возможные варианты событий.
10. Определить, является ли число положительным или отрицательным;*/
fun isPositive(a:Int){
    if (a > 0) {
        println("Число положительное")
    } else
        println("Число отрицательное")
}

/*Тема: Неизменяемые коллекции.
10. Заменить все отрицательные числа их квадратами.*/
fun squaresNegativeNumbers(arr:Array<Int>){
    for(i in 0 until arr.size){
        if (arr[i] < 0)
            arr[i] = arr[i] * arr[i]
    }
    for(i in 0 until arr.size)
        print("${arr[i]} ")
    println()
}

/*Тема работы: Изменяемые коллекции.
Создать одномерный массив с целыми числами. Составить еще один одномерный массив,
который будет содержать только ... из исходного массива:
10. С индексами больше того, что указал пользователь, в обратном порядке.*/
fun arrayOpposite(arr:Array<Int>, index:Int){
    for(i in arr.size - 1 downTo index + 1)
        print("${arr[i]} ")
    println()
}

/*Тема работы: Вложенные коллекции.
10. Посчитать количество чисел в строке, которые близки к среднему арифметическому столбца.*/
fun arithmeticMeanColumn(array:Array<Array<Int>>){
    var count = 0
    var countNumber = 0
    for (j in 0 until array.size){
        var sum = 0
        for (i in 0 until array.size) {
            sum += array[i][j]
        }
        val srArif = sum / array.size
        for(i in array.indices)
            if (array[i][j] == srArif)
                count++
    }
    println(count)
}

/*Работа с классом String.
10. Добавить по символу '_' в начало и конец каждого слова;*/
fun addingSymbol(str:String){
    val str1 = str.split(" ").toMutableList()
    for(i in str1.indices) {
        str1[i] = "_" + str1[i]
    }
    println(str1.joinToString(" "))
}

fun main() {
    //1
    val number = readln().toInt()
    isPositive(number)

    //2
    val arrayNumberInt: Array<Int> = arrayOf(1, -2, -3, 4, 5, -6, 7, 8, -9, 10)
    squaresNegativeNumbers(arrayNumberInt)

    //3
    val index = readln().toInt()
    arrayOpposite(arrayNumberInt, index)

    //4
    val arrayNumber = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5, 6),
        arrayOf(7, 8, 9)
    )
    arithmeticMeanColumn(arrayNumber)

    //5
    val str = readln()
    addingSymbol(str)
}
