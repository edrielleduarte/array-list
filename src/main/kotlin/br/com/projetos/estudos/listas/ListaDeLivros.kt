package br.com.projetos.estudos.listas

fun main(){
    val livro1 = Livro(
        titulo = "HP pedra filosofal",
        autor = "Jk Roling",
        anoPublicacao = 2000,
    )

    val livro2 = Livro(
        titulo = "HP Camera Secreta",
        autor = "Jk Roling",
        anoPublicacao = 2001,
        editora = "Saraiva"
    )

    val livro3 = Livro(
        titulo = "HP prisioneiro de Akaban",
        autor = "Jk Roling",
        anoPublicacao = 2002,
        editora = "Saraiva"
    )

    val livro4 = Livro(
        titulo = "HP Calice de Fogo",
        autor = "Jk Roling",
        anoPublicacao = 2003,
        editora = "Saraiva"
    )

    val livros: MutableList<Livro> = mutableListOf(livro1, livro2, livro3, livro4)

    livros.add(
        Livro(
            titulo = "HP Ordem da Fenix",
            autor = "Jk Roling",
            anoPublicacao = 2004
        )
    )

//    livros.imprimeComMarcadores()

//    livros.remove(livro1)

//    livros.imprimeComMarcadores()


    val ordenadoAnoPublicacao: List<Livro> = livros.sorted()

//    ordenadoAnoPublicacao.imprimeComMarcadores()

    val ordenadoPorTitulo: List<Livro> = livros.sortedBy { it.titulo }
//    ordenadoPorTitulo.imprimeComMarcadores()

//    livros.sortedBy { it.autor }.imprimeComMarcadores()

   val titulos: List<String> = ListaDeLivrosNovas.filter { it.autor.startsWith("João") }
        .sortedBy { it.anoPublicacao }
        .map { it.titulo }

    println(titulos)
}
