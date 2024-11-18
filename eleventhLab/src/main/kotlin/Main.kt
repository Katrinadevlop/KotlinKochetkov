import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

// 1. Создать прерываемую функцию (suspend)
suspend fun suspendableTask() {
    delay(1000)
    println("Прерываемая задача завершена")
}

// 2. Создать задачу при помощи launch
fun launchTask() = runBlocking {
    launch {
        delay(1000)
        println("Задача выполнена через launch")
    }
}

// 3. Создать задачу, которая будет возвращать значение при помощи async
fun asyncTask() = runBlocking {
    val deferred = async {
        delay(1000)
        return@async "Результат из async"
    }
    println("Ожидание результата async...")
    val result = deferred.await()
    println("Результат async: $result")
}

// 4. Создать массив задач при помощи launch
fun arrayLaunchTasks() = runBlocking {
    val tasks = mutableListOf<Job>()
    for (i in 1..5) {
        val task = launch {
            delay(1000L * i)
            println("Задача $i завершена")
        }
        tasks.add(task)
    }
    tasks.forEach { it.join() }
}

// 5. Создать массив задач при помощи async
fun arrayAsyncTasks() = runBlocking {
    val tasks = (1..5).map { i ->
        async {
            delay(1000L * i)
            "Результат задачи $i"
        }
    }
    tasks.forEach { println(it.await()) }
}

fun main() = runBlocking {
    println("\n1. Прерываемая функция:")
    suspendableTask()

    println("\n2. Задача через launch:")
    launchTask()

    println("\n3. Задача через async:")
    asyncTask()

    println("\n4. Массив задач через launch:")
    arrayLaunchTasks()

    println("\n5. Массив задач через async:")
    arrayAsyncTasks()

}
