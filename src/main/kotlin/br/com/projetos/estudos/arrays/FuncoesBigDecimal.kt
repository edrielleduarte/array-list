import java.math.BigDecimal
import java.math.RoundingMode

fun calculoAumentoRelativo(salario: BigDecimal, aumento: BigDecimal): BigDecimal {
    return if (salario < "5000".toBigDecimal()) {
        salario + "500".toBigDecimal()
    } else {
        (salario * aumento).setScale(2, RoundingMode.UP)
    }
}

fun bigDecimalArrayOf(vararg valores: String): Array<BigDecimal> {
    return Array<BigDecimal>(valores.size){ i ->
        valores[i].toBigDecimal()
    }
}


fun Array<BigDecimal>.somatoria(): BigDecimal {
    return this.reduce { acumalador, valor ->
        acumalador + valor
    }
}

fun Array<BigDecimal>.media(): BigDecimal {
    return if(this.isEmpty()){
        BigDecimal.ZERO
    } else{
        this.somatoria() / this.size.toBigDecimal()
    }
}