import java.util.concurrent.Callable
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import kotlin.jvm.Throws

/*Лабораторная работа №10
Тема: Многопоточность Java
1. Создать поток при помощи наследования от интерфейса Runnable;
2. Создать поток при помощи наследования от Thread;
3. Создать поток при помощи Callable и Futures;
4. Создать массивы потоков для первых трёх заданий;
5. Создать массив потоков, как только будет готов результат хотя бы в одном из них - отменить остальные;
6. Создать массив потоков, как только будут готовы результаты первых трёх потоков - отменить остальные;
7. Создать массив потоков, выводить результат выполнения каждого потока сразу как только он будет готов;
8. Создать массив потоков, как только очередной поток вернет результат - ставить на паузу на 1 секунду все оставшиеся потоки.*/

//1. Создать поток при помощи наследования от интерфейса Runnable
class MyThread: Runnable{
    override fun run() {
        repeat(10)
        {
            println("Единорог")
        }
    }
}

//2. Создать поток при помощи наследования от Thread;
class MyThreadTwo: Thread() {
    override fun run() {
        repeat(5)
        {
            println("Ест")
        }
    }
}

//3. Создать поток при помощи Callable и Futures;
fun prints():String{
    return "Радугу"
}

fun main() {
    val myThread = Thread(MyThread())
    myThread.start()
    myThread.join()

    val myThreadTwo = Thread(MyThreadTwo())
    myThreadTwo.start()
    myThreadTwo.join()

    //3. Создать поток при помощи Callable и Futures;
    val executor = Executors.newFixedThreadPool(1)
    val callableTask = Callable(::prints)
    val future = executor.submit(callableTask)
    try {
        val result = future.get()
        println("Результат: $result")
    } catch (e: InterruptedException) {
        e.printStackTrace()
    } catch (e: ExecutionException) {
        e.printStackTrace()
    }
    executor.shutdown()

    //4. Создать массивы потоков для первых трёх заданий;
    val threads = arrayOf(
        Thread(MyThread()),
        MyThreadTwo(),
        Thread {
            try {
                val result = callableTask.call()
                println("Результат: $result")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    )

    threads.forEach { it.start() }
    threads.forEach { it.join() }

    //5. Создать массив потоков, как только будет готов результат хотя бы в одном из них - отменить остальные;
}