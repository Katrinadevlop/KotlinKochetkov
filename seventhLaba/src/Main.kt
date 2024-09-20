import kotlin.reflect.full.allSuperclasses
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties

/*Лабораторная работа №7
Тема: Рефлексия
1. Вывести список всех атрибутов класса;
2. Вывести список ВСЕХ предков;
3. Вывести список всех МЕТОДОВ класса;
4. Вывести список всех СВОЙСТВ класса;
5. Вывести список аргументов функции;
6. Вывести список ТИПОВ аргументов функции;
7. Добавить свойство в класс (исследовательская работа);
8. Добавить метод в класс (исследовательская работа);
9. Изменить метод в классе (исследовательская работа);
10. Изменить метод в классе-предке (исследовательская работа);
11. Удалить метод в классе (исследовательская работа);
12. Удалить свойство в классе (исследовательская работа).*/

open class People(val name:String, val age:Int){
    open fun printName(age:Int) = println("$name, $age")
    open fun findYearBirth() = 2024 - age
}

class Student(name:String, age:Int, val specialization:String):People(name, age){
    override fun findYearBirth(): Int {
        return super.findYearBirth()
    }

    override fun printName(age:Int) = println("Студента зовут $name, возрастом $age")

    fun printSpecialization(gender:String) = println("Студент по имени $name учится на специальности $specialization, $gender")
}

fun main() {
    val student = Student("Екатерина", 19, "Программист")
    //1. Вывести список всех атрибутов класса
    for (value in student::class.memberProperties){
        println("${value.name}")
    }
    println()

    // 2. Вывести список ВСЕХ предков
    for (value in student::class.allSuperclasses){
        println("${value.simpleName}")
    }
    println()

    // 3. Вывести список всех МЕТОДОВ класса
    for (value in student::class.memberFunctions){
        println("${value.name}")
    }
    println()

    // 4. Вывести список всех СВОЙСТВ класса
    for (value in student::class.declaredMemberProperties){
        println("${value.name}")
    }
    println()

    val printSpecialization = student::class.memberFunctions.find { it.name == "printSpecialization" }
    // 5. Вывести список аргументов функции (например, для метода calculateCalories)
    if (printSpecialization != null) {
        for (value in printSpecialization.parameters){
            println("${value.name}")
        }
    }
    println()

    // 6. Вывести список ТИПОВ аргументов функции
    if (printSpecialization != null) {
        for (value in printSpecialization.parameters){
            println("${value.type}")
        }
    }
    println()

    //7. Добавить свойство в класс (исследовательская работа);
}