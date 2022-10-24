package br.com.projetos.estudos.listas

fun main(){
    val prateleira = Prateleira("Literatura", livros = ListaDeLivrosNovas)

    val porAutor = prateleira.organizarPorAutor()
    val porAnoPublicacao = prateleira.organizarPorAnoPublicacao()

    porAutor.imprimeComMarcadores()
    porAnoPublicacao.imprimeComMarcadores()
}