fun main() {
    println("Bem vindo ao Bytebank")

    val contaAlex = Conta()                  //instancia tipo conta
    contaAlex.titular = "Alex"
    contaAlex.numeroConta = 1001
    contaAlex.setSaldo(2000.0)

    println(contaAlex.titular)
    println(contaAlex.numeroConta)
    println(contaAlex.getSaldo())

    val contaFran = Conta()
    contaFran.titular = "Fran"
    contaFran.numeroConta = 1002
    contaFran.setSaldo(300.0)

    println(contaFran.titular)
    println(contaFran.numeroConta)
    println(contaFran.getSaldo())

    contaAlex.deposita(50.0)
    println(contaAlex.getSaldo())

    contaAlex.saca(1000.0)
    println(contaAlex.getSaldo())
    //contaAlex.saca(1100.0)
    //println(contaAlex.saldo)

    if (contaAlex.transfere(1500.0, contaFran)) {
        println("Ok")
    } else {
        println("Falha")
    }


}

class Conta {                                             //Classe em Kotlin, sempre precisa definir valor para variavel
    var titular = ""
    var numeroConta = 0
    private var saldo = 0.0                   //Encapsulamento de saldo, sendo envolvida no metodo abaixo que devolve uma copia de Saldo.

    fun getSaldo(): Double {
        return saldo
    }

    fun setSaldo(valor: Double) {
        if (valor > 0){
         saldo = valor
        }
    }
    fun deposita(valor: Double) {         //Criamos a função deposita agora dentro da classe Conta.
        saldo += valor
        //le se this.saldo += valor
    }
    // A função abaixo esta correta, porém não atende os melhores padrões de orientacao a objeto, quem deve gerenciar os comportamentos/funcoes/metodos é a propria classe.
//fun deposita(conta: Conta, valor: Double){        //Espera atrubuto/parametro tipo conta + valor em Double a ser incrementado
//    conta.saldo += valor
//    //deposita(contaAlex,50.0) - Exemplo de chamada do metodo deposita para depositar na Conta
//}

    fun saca(valor: Double) {
        if (saldo >= valor) {
            saldo -= valor
        } else {
            print("Saldo Indisponivel!")
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        if (saldo >= valor) {
            saldo -= valor
//            destino.saldo += valor  - Não é ideal usar desta forma pois estamos modificando um atributo diretamente, atribuindo mais uma responsabilidade ao metodo que ja existe
            destino.deposita(valor) // Forma ideal, já que possuimos um metodo ja criado com essa responsabilidade
            return true
        }
        return false
    }
}

fun testaCopiasEReferencias() {
    val numeroInt = 100
    var numeroDouble = numeroInt

    println(numeroInt)
    println(numeroDouble)

    val contaTassya = Conta()
    contaTassya.titular = "Tassya"
    var contaMateus = Conta()
    contaMateus.titular = "Tassya"

    println("titular conta Mateus :  ${contaMateus.titular}")
}

fun testaLacos() {
    var i = 0
    while (i < 5) {
        val titular: String = "Alex $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0

        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")
        println()
        i++
    }

    for (i in 5 downTo 1) {                  //For em Kotlin
        val titular: String = "Alex $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0

        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")
        println()
    }
}

fun testaCondicoes(saldo: Double) {
    if (saldo > 0.0) {
        println("conta é positiva")
    } else if (saldo == 0.0) {
        println("conta é neutra")
    } else {
        println("conta é negativa")
    }

    when {
        saldo > 0.0 -> println("conta é positiva")
        saldo == 0.0 -> println("conta é neutra")
        else -> println("conta é negativa")
    }
}


//_________________________________________________________________ Meus Rascunhos:

//fun main() {
//    println("Bem vindo ao Bytebank")
//
//    //  Você pode definir essa variável tanto como mutável (var) como imutável (val).
//
//    for (i in 1..5) {
//        val titular: String = "Alex"
//        val numeroConta: Int = 1000
//        var saldo = 100.0
////    saldo = 200.0
////    saldo += 50
//        println("Titular $titular")
//        println("numeroConta $numeroConta ")
//        println("saldo $saldo")
//
//        //testaCondicoes(saldo)
//
//    }
//
//    fun testaCondicoes(saldo: Double) {
//        if (saldo > 0.0) {
//            println("A conta é positiva.")
//        } else if (saldo == 0.0) {
//            println("A conta é neutra.")
//        } else {
//            println("A conta é negativa!")
//        }
//    }
//
////    when {
////        saldo > 0.0 -> println("A conta é positiva.")
////        saldo == 0.0 -> println("A conta é neutra.")        //Substiui o uso dos ifs acima
////        else -> println("A conta é negativa!")
////    }
//
////    for (i in 1..5){
////        println(i)
////    }
////
////    for (i in 5 downTo 1){
////        println(i)               ////cria 5 contas na ordem decrescente
////    }
//
//    for (i in 5 downTo 2 step 2){
//        println(i)
//    }
//
//}