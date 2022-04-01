import kotlin.math.abs

data class Money2(private val rub: Int,private val kop: Int){
    fun showBalance(){
        println("$rub $kop")
    }
}

class Money(rub: Int = 0, kop: Int = 0){
    private var ruble: Int
    private var kop: Int

    init {
        ruble = rub
        this.kop = kop
    }

    fun sum(money: Money){
        kop += money.kop
        ruble += money.ruble + kop/100
        kop %= 100
    }

    fun minus(money: Money): Money{
        var sign = 1
        var money1Kop = money.ruble * 100 + money.kop
        var money2Kop = ruble * 100 + kop
        var res = money2Kop - money1Kop
        if (res < 0){
            res = abs(res)
            sign = -1
        }

        return Money(sign * res / 100, res % 100)
    }

    fun showBalance(){
        println("рублей $ruble, копеек $kop")
    }

    companion object{
        fun minus(m1: Money, m2: Money){
            println("Работает")
        }
    }
}

fun main(args: Array<String>) {
//    var money1 = Money(10, 30)
//    var money2 = Money(90, 50)
//    var money3 = money1
//    Money.minus(money1, money2)
//    money1.minus(money2).showBalance()
//    println(money1 === money2)
    var m1 = Money2(10, 40)
    var m2 = Money2(10, 40)
    m1.showBalance()
    println(m1 == m2)
    var m3 = m1.copy()
    println(m3 == m1)
    
}