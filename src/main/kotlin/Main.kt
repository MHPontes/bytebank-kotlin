fun main() {
    println ("Bem vindo ao Bytebank")

  //  Você pode definir essa variável tanto como mutável (var) como imutável (val).

    val titular: String = "Alex"
    val numeroConta: Int = 1000
    var saldo = 100.0
//    saldo = 200.0
//    saldo += 50
    println ("Titular $titular")
    println ("numeroConta $numeroConta ")
    println ("saldo $saldo")


//    if (saldo > 0.0) {
//        println ("A conta é positiva.")
//    } else if (saldo == 0.0) {
//        println("A conta é neutra.")
//    } else {
//        println("A conta é negativa!")
//    }

    when {
        saldo > 0.0 ->  println ("A conta é positiva.")
        saldo == 0.0 ->  println("A conta é neutra.")        //Substiui o uso dos ifs acima
        else ->  println("A conta é negativa!")
    }

}