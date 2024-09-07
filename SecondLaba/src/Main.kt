fun isPositive(a:Int){
    if (a > 0) {
        println("Число положительное")
    } else
        println("Число отрицательное")
}

fun squaresNegativeNumbers(arr:Array<Int>){
    for(i in 0 until arr.size){
        if (arr[i] < 0)
            arr[i] = arr[i] * arr[i]
    }
    for(i in 0 until arr.size)
        print("${arr[i]} ")
    println()
}

fun arrayOpposite(arr:Array<Int>, index:Int){
    for(i in arr.size - 1 downTo index + 1)
        print("${arr[i]} ")
    println()
}

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

fun addingSymbol(str:String){
    val str1 = str.split(" ").toMutableList()
    for(i in str1.indices) {
        str1[i] = "_" + str1[i]
    }
    println(str1.joinToString(" "))
}

fun main() {
    val number = readln().toInt()
    isPositive(number)

    val arrayNumberInt: Array<Int> = arrayOf(1, -2, -3, 4, 5, -6, 7, 8, -9, 10)
    squaresNegativeNumbers(arrayNumberInt)

    val index = readln().toInt()
    arrayOpposite(arrayNumberInt, index)

    val arrayNumber = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5, 6),
        arrayOf(7, 8, 9)
    )
    arithmeticMeanColumn(arrayNumber)

    val str = readln()
    addingSymbol(str)
}
