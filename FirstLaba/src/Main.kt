fun squaresNegativeNumbersArray(arr:Array<Int>){
    for(i in 0 until arr.size){
        if (arr[i] < 0)
            arr[i] = arr[i] * arr[i]
    }
    for(element in arr)
        print("${element} ")
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
            print(tmp)
    }
}

fun squaresNegativeNumbersMutableList(arr:MutableList<Int>) {
    for (i in 0 until arr.size) {
        if (arr[i] < 0)
            arr[i] = arr[i] * arr[i]
    }

    arr.forEachIndexed() { _, name ->
        print("$name ")
    }
}

fun squaresNegativeNumbersSet(arr: Set<Int>) {
    println(arr.filter{i -> i < 0})
}

fun squaresNegativeNumbersMutableSet(arr: MutableSet<Int>) {
    println(arr)
}
/*
fun squaresNegativeNumbers(arr: Map<Int>) {
    for (i in 0 until arr.size) {
        if (arr[i] < 0)
            arr[i] = arr[i] * arr[i]
    }
    for (i in 0 until arr.size)
        print("${arr[i]} ")
    println()
}

fun squaresNegativeNumbers(arr: Map<Int>) {
    for (i in 0 until arr.size) {
        if (arr[i] < 0)
            arr[i] = arr[i] * arr[i]
    }
    for (i in 0 until arr.size)
        print("${arr[i]} ")
    println()
}*/

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
}
