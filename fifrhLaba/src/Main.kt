class dominoBone(sizeLeftSide:Int, sizeRightSide:Int){
    private var id = 0
    var sizeLeftSide:Int = 0
        get(){
            return field
        }

        private set(value: Int) {
            field = value
        }

    var sizeRightSide:Int = 0
        get(){
            return field
        }

        private set(value: Int){
            field = value
        }

    init {
        this.sizeLeftSide = sizeLeftSide
        this.sizeRightSide = sizeRightSide
    }

    private var numberLeft = 0
    private var numberRight = 0
    protected var isUsed = false
    internal var flipped = false

    protected fun isDouble():Boolean{
        if (numberRight == numberLeft) return true
        else return false
    }

    internal fun flip(){
        val temp: Int = sizeLeftSide
        sizeLeftSide = sizeRightSide
        sizeRightSide = temp
        flipped = !flipped
    }

    private fun markAsUsed(isUsed:Boolean):String{
        this.isUsed = isUsed
        if (isUsed) return "Да"
        else return "Нет"
    }

    fun getTotal():Int{
        val result = numberRight + numberLeft
        return result
    }

    override fun toString():String{
        return "${numberRight} | ${numberLeft}"
    }

    companion object {
        private var id = 0

        var sizeLeftSide1:Int = 0
            get(){
                return field
            }

            set(value: Int) {
                if (field < 0) field = 0
                if (field > 5) field = 100
                field = value
            }

        var sizeRightSide1:Int = 0
            get(){
                return field
            }

            set(value: Int){
                if(field < 0) field = 0
                if(field > 5) field = 100
                field = value
            }

        private var numberLeft1 = 0
        private var numberRight1 = 0
        protected var isUsed1 = false
        internal var flipped1 = false

        protected fun isDouble():Boolean{
            if (numberRight1 == numberLeft1) return true
            else return false
        }

        internal fun flip(){
            val temp: Int = sizeLeftSide1
            sizeLeftSide1 = sizeRightSide1
            sizeRightSide1 = temp
            flipped1 = !flipped1
        }

        private fun markAsUsed(isUsed:Boolean):String{
            this.isUsed1 = isUsed
            if (isUsed) return "Да"
            else return "Нет"
        }

        public fun getTotal():Int{
            val result = numberRight1 + numberLeft1
            return result
        }

        override fun toString():String{
            return "${numberRight1} | ${numberLeft1}"
        }
    }
}

interface IPrice{
    fun printPrise(prise:Int):String
}

interface IExpirationDate{
    fun printExpirationDate(expirationDate:Int):Int
}

open abstract class Eat(var name:String){
    open fun prints(name:String):String{
        return "${name}"
    }
}

class Banana(name:String) : Eat(name), IPrice, IExpirationDate{
    override fun prints(name:String):String{
        return "${name}, Banana"
    }

    override fun printPrise(prise:Int): String {
        return "$prise"
    }

    override fun printExpirationDate(expirationDate:Int):Int {
        return expirationDate
    }
}

class Watermelon(name:String) : Eat(name), IPrice, IExpirationDate{
    override fun prints(name:String):String{
        return "${name}, Watermelon"
    }

    override fun printPrise(prise:Int):String{
        return "Цена: $prise"
    }

    override fun printExpirationDate(expirationDate:Int):Int {
        return expirationDate
    }
}

fun main() {
    val dominoBone = dominoBone(2,5)
    println(dominoBone.flip())
    println(dominoBone.getTotal())
    println(dominoBone.toString())


}