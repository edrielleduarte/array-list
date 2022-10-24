fun intarraysex(){
    val idades: IntArray = intArrayOf(10, 12, 18, 33, 40, 67)
    val maiorIdade = idades.min()
    println("A maior idade é: $maiorIdade")


    val media = idades.average()
    println("Media é $media")

    val todosMaiores = idades.all { it > 18 }
    println("todos maiores? $todosMaiores")

    val existeMaior = idades.any{ it >=18 }
    println("Maior de idade $existeMaior")

    val maiores = idades.filter { it >= 18 }
    println("Maiores: $maiores")

    val encontrarValor = idades.find { it >= 18 }
    println("Busca: $encontrarValor")
}