import java.math.BigDecimal
import java.math.RoundingMode

fun teste(){
    val salarios = bigDecimalArrayOf("1500.50", "2000.00", "5000.00", "10000.00")

    val aumento = "1.1".toBigDecimal()

    val aumentoSalarios: Array<BigDecimal> = salarios
        .map { salario ->
            calculoAumentoRelativo(salario, aumento)
        }.toTypedArray()

//    println(aumentoSalarios.contentToString())

    val gastoInicial = aumentoSalarios.somatoria()
//    println(gastoInicial)

    val meses = 6.toBigDecimal()
    val gastoTotal = aumentoSalarios.fold(gastoInicial) { acumulador, salario ->
        acumulador + (salario * meses).setScale(2, RoundingMode.UP)
    }
//    println(gastoTotal)
    println(aumentoSalarios.sorted())
    val media = aumentoSalarios.sorted().take(3).toTypedArray().media()
    println(media)
}