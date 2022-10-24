package br.com.projetos.estudos.listas


val ListaDeLivrosNovas = mutableListOf(
    Livro( titulo = "Sr dos Aneis",
        autor = "Nops 1",
        anoPublicacao = 2000,
        editora = "Saraiva"
    ),
    Livro( titulo = "Sr dos Aneis 5",
        autor = "Nopseira 2",
        anoPublicacao = 1922,
    ),
    Livro( titulo = "A terra dos que n foram",
    autor = "Nops 1",
    anoPublicacao = 2013,
    ),
    Livro( titulo = "A terra dos que n foram",
        autor = "Nops 1",
        anoPublicacao = 2013,
    ),
    Livro( titulo = "As tranças do rei careca",
        autor = "João",
        anoPublicacao = 2013,
    ),
    Livro( titulo = "As muralhas",
        autor = "João",
        anoPublicacao = 2016,
    )
)

val ListaDeLivrosComNulos: MutableList<Livro?> = mutableListOf(
    Livro( titulo = "Sr dos Aneis",
        autor = "Nops 1",
        anoPublicacao = 2000,
        editora = "Saraiva"
    ),
    Livro( titulo = "Sr dos Aneis 5",
        autor = "Nopseira 2",
        anoPublicacao = 2022,
    ),
    null,
    Livro( titulo = "A terra dos que n foram",
        autor = "Nops 1",
        anoPublicacao = 2013,
    ),
    Livro( titulo = "A terra dos que n foram",
        autor = "Nops 1",
        anoPublicacao = 2013,
    ),
    Livro( titulo = "As tranças do rei careca",
        autor = "João",
        anoPublicacao = 2013,
    ),
    Livro( titulo = "As muralhas",
        autor = "João",
        anoPublicacao = 2016,
    )
)