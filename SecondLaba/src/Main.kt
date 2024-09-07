/*Лабораторная работа №2.
Предоставить примеры использования классов: Array, IntArray, List, MutableList, Set, MutableSet,
 Map, MutableMap. В качестве материалов использовать задачи из предыдущей лабораторной работы по вариантам.*/

fun squaresNegativeNumbersArray(arr:Array<Int>){
    for(i in arr.indices){
        if (arr[i] < 0)
            arr[i] = arr[i] * arr[i]
    }
    for(element in arr)
        print("$element ")
    println()
}

fun squaresNegativeNumbersArrayInt(arr:IntArray){
    for(i in arr.indices){
        if (arr[i] < 0)
            arr[i] = arr[i] * arr[i]
    }
    for(element in arr)
        print("$element ")
    println()
}

fun squaresNegativeNumbersList(arr: List<Int>){
    val array = arr.iterator()
    while(array.hasNext()){
        val tmp = array.next()
        if (tmp < 0)
            print("${tmp * tmp} ")
        else
            print("$tmp ")
    }
    println()
}

fun squaresNegativeNumbersMutableList(arr:MutableList<Int>) {
    for (i in 0..<arr.size) {
        if (arr[i] < 0)
            arr[i] = arr[i] * arr[i]
    }

    arr.forEachIndexed() { _, name ->
        print("$name ")
    }
}

fun squaresNegativeNumbersSet(arr: Set<Int>) {
    val set = arr.map{if (it < 0) it*it else it}
    println(set)
}

fun squaresNegativeNumbersMutableSet(arr: MutableSet<Int>) {
    val set = arr.map{if (it < 0) it*it else it}
    println(set)
}

fun squaresNegativeNumbersMap(arr: Map<String, Int>) {
    val set = arr.map{it.key to if (it.value < 0) it.value * it.value else it.value}.toMap()
    println(set)
}


fun squaresNegativeNumbersMutableMap(arr: MutableMap<String, Int>) {
    val set = arr.map{it.key to if (it.value < 0) it.value * it.value else it.value}.toMap()
    println(set)
}


fun main() {
    val arrayNumber: Array<Int> = arrayOf(1, -2, -3, 4, 5, -6, 7, 8, -9, 10)
    squaresNegativeNumbersArray(arrayNumber)

    val arrayNumberInt: IntArray = intArrayOf(1, -2, -3, 4, 5, -6, 7, 8, -9, 10)
    squaresNegativeNumbersArrayInt(arrayNumberInt)

    val arrayList: List<Int> = listOf(1, -2, -3, 4, 5, -6, 7, 8, -9, 10)
    squaresNegativeNumbersList(arrayList)

    val arrayMutableList: MutableList<Int> = mutableListOf(1, -2, -3, 4, 5, -6, 7, 8, -9, 10)
    squaresNegativeNumbersMutableList(arrayMutableList)
    println()

    val arraySet:Set<Int> = setOf(1, -2, -3, 4, 5, -6, 7, 8, -9, 10)
    squaresNegativeNumbersSet(arraySet)

    val arrayMutableSet:MutableSet<Int> = mutableSetOf(1, -2, -3, 4, 5, -6, 7, 8, -9, 10)
    squaresNegativeNumbersMutableSet(arrayMutableSet)

    val arrayMap:Map<String, Int> = mapOf("1" to 1, "-2" to -2, "-3" to -3, "4" to 4, "5" to 5, "-6" to -6, "7" to 7, "8" to 8, "-9" to -9, "10" to 10)
    squaresNegativeNumbersMap(arrayMap)

    val arrayMutableMap:MutableMap<String, Int> = mutableMapOf("1" to 1, "-2" to -2, "-3" to -3, "4" to 4, "5" to 5, "-6" to -6, "7" to 7, "8" to 8, "-9" to -9, "10" to 10)
    squaresNegativeNumbersMutableMap(arrayMutableMap)
}
