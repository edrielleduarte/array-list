package br.com.projetos.estudos.listas

fun main(){
    ListaDeLivrosNovas.groupBy { it.editora ?: "Editora Desconhecida"}
        .forEach { (editora: String, livros: List<Livro>) ->
            println("Nome $editora: ${livros.joinToString { it.titulo }}")
        }
}