package br.com.projetos.estudos.listas

fun List<Livro?>.imprimeComMarcadores(){
    val textoFormatado = this
        .filterNotNull()
        .joinToString(separator = "\n") {
        " - ${it.titulo} de ${it.autor}"
    }

    println(" \n ###### Lista de Livros ###### \n\n$textoFormatado")
}