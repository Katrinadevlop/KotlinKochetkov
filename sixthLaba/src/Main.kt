import javax.management.StringValueExp

/*Лабораторная работа №6
Тема: Специфичные классы Kotlin
1. Разработать class enum;
2. Разработать data class;
3. Привести пример паттерна "Фабрика";
4. Привести пример ИСПОЛЬЗОВАНИЯ паттерна "Строитель".*/

enum class Peoples(val people:String){
    Student("Студент"){
       val age = 16
    },
    Worker("Рабочий"){
        val age = 35
    }
}

data class Strudent(
    val name:String,
    val age:Int,
    val whoStudying:String,
    val isWork:Boolean
)

class Color{
    var color:String

    private constructor(color: String) {
        this.color = color
    }

    companion object{
        fun darkColor(color: String):Color {
            return Color(color)
        }

        fun lightColor(color: String):Color {
            return Color(color)
        }
    }
}

class Item{

    private constructor()

    companion object{
        // Создание билдера
        fun builder(): ItemBuilder{
            return ItemBuilder()
        }

        // Реализация интерфейсов снаружи
        class ItemBuilder: Builder{
            // Временная переменная, куда по одному устанавливаются значения в ходе сборки
            private val item: Item = Item()

            // Точка входа для создания еды, публичная
            override fun food(hunger: Int): EffectBuidler {
                this@ItemBuilder.item.food = Food(hunger)
                return EffectBuilderImpl()
            }

            // Часть цепочки, приватная, чтобы в неё можно было попасть только из определённой точки входа
            private inner class EffectBuilderImpl: EffectBuidler{
                override fun effect(effect: Effect): ItemFinalBulderImpl {
                    this@ItemBuilder.item.effect = effect
                    return ItemFinalBulderImpl()
                }
            }

            // Финал сборки
            private inner class ItemFinalBulderImpl : Builder by this@ItemBuilder, ItemFinalBulder {
                override fun build(): Item{
                    return item
                }
            }
        }
    }

    // Начало, Билдер, который наследует от всех интерфейсов точек входа
    interface Builder: FoodBuidler

    // Еда, точка входа
    lateinit var food: Food
    class Food(val hunger: Int)
    interface FoodBuidler{
        abstract fun food(hunger: Int): EffectBuidler
    }

    // Продолжение, Effect можно задать СТРОГО ПОСЛЕ food
    lateinit var effect: Effect
    enum class Effect{
        Heal, Harm
    }
    interface EffectBuidler{
        abstract fun effect(effect: Effect): ItemFinalBulder
    }

    // Конец всех цепочек билдера
    interface ItemFinalBulder : Builder {
        fun build(): Item
    }

}

fun main() {
    println(Peoples.Student.people)
    println(Peoples.Worker.people)

    val strudent = Strudent("Екатерина", 19, "Программист", true)
    println(strudent)

    val color = Color.lightColor("Светлый")
    val color1 = Color.darkColor("Темный")
    println(color.color)
    println(color1.color)

    val item = Item.builder()
        .food(5)
        .effect(Item.Effect.Heal)
        .build()

    println("Food have: hunger: ${item.food.hunger}, effect: ${item.effect}")
}