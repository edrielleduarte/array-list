package br.com.projetos.estudos.arrays//import java.math.BigDecimal
//import java.math.RoundingMode
//
//fun teste() {
//
//    val salarios = bigDecimalArrayOf("1500.50", "2000.00", "5000.00", "10000.00")
//
//    val aumento = "1.1".toBigDecimal()
//
//    val aumentoSalarios: Array<BigDecimal> = salarios
//        .map { salario ->
//            if (salario < "5000".toBigDecimal()) {
//                salario + "500".toBigDecimal()
//            } else {
//                (salario * aumento).setScale(2, RoundingMode.UP)
//            }
//        }.toTypedArray()
//
//    println(aumentoSalarios.contentToString())
//}
//
//fun bigDecimalArrayOf(vararg valores: String): Array<BigDecimal> {
//    return Array<BigDecimal>(valores.size){ i ->
//        valores[i].toBigDecimal()
//    }
//}