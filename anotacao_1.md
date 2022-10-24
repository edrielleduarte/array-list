# Listas

O array não é a única estrutura de dados que nós conseguimos trabalhar, as listas funcionam de forma muito parecida com o array, mas elas têm algumas particularidades.
ara mostrarmos a funcionalidade das listas, vamos criar uma biblioteca pessoal, onde vamos colocar alguns livros, remover livros e ordenar esses livros.
“data class Livro {}” aqui, do Kotlin. Não vamos utilizar a “class” normal, vamos utilizar “data class”. O “data class” é um tipo especial de classe do Kotlin,
porque ela fornece, além das características normais de uma classe, algumas funções e métodos automaticamente.
E para cada um desses atributos que formos criando, ele já vai criar automaticamente, em tempo de compilação, um método “toString”, um método “equals”, um “hashCode”, 
tudo para nós, automaticamente dentro dessa classe.

* vamos ter no data class Livros variavel pra titulo do livro, ano de publicacao, autora e a editora vai ser do tipo string com o ?
e valor null, quando nao tiver, ele vai ser null;

` Exemplo:`
    
                data class Livro(
                    val titulo: String,
                    val auto: String,
                    val anoPublicacao: Long,
                    val editora: String? = null
                )

na main:

                    val livro1 = Livro(
                        titulo = "HP pedra filosofal",
                        auto = "Jk Roling",
                        anoPublicacao = 2000,
                    )
                
                    val livro2 = Livro(
                        titulo = "HP Camera Secreta",
                        auto = "Jk Roling",
                        anoPublicacao = 2001,
                        editora = "Saraiva"
                    )
                
                    val livro3 = Livro(
                        titulo = "HP prisioneiro de Akaban",
                        auto = "Jk Roling",
                        anoPublicacao = 2002,
                        editora = "Saraiva"
                    )
                
                    val livro4 = Livro(
                        titulo = "HP Calice de Fogo",
                        auto = "Jk Roling",
                        anoPublicacao = 2003,
                        editora = "Saraiva"
                    )

                    val livros = mutableListOf(livro1, livro2, livro3, livro4)


Para criar uma lista desses dados, livro1, livro2, livro3, livro4 com o “mutableListOf<>()”. A “mutableListOf” é uma lista mutável de “(livro1, livro2, livro3, livro4)”.

Aqui temos uma lista de livros, vamos chamar essa lista de “val livros”. O IntelliJ omitiu o tipo da variável, mas podemos colocar, para ficar claro aqui que estamos trabalhando 
com uma “MutableList” do tipo ““.

                        val livros: MutableList<Livros> = mutableListOf(livro1, livro2, livro3, livro4)

* `OBS:` Repare que eu tive que colocar esse valor aqui entre maior e menor, assim como fizemos com os arrays de objeto de “BigDecimal”. As listas vão trabalhar de forma muito parecida.

Você não vai ter lista de tipo primitivo, assim como temos o “intArrayOf”, o “intArray”. No tipo “IntArray”, não temos o tipo “intList”. A lista sempre vai trabalhar com objetos, então 
vamos trabalhar com lista de “int”, mas vai ser sempre uma lista de objetos do tipo “int”, nunca o tipo primitivo “int”.

* Diferença do array x listas?
   - Quando você cria o `Array` ele é fixo, ele vai ter aquele tamanho para sempre. Se você precisar de um array maior, você tem que criar um novo array e acrescentar todos os elementos daquele array mais o valor novo.
   - Na `lista`, não. Quando trabalhamos com listas mutáveis, conseguimos acrescentar um valor novo para a nossa lista.


Poderia adicioar o metodo add a variavel livros que foi juntado as listas. Exemplo:

        val livros = mutableListOf(livro1, livro2, livro3, livro4)

        livros.add(
            Livro(
                titulo = "HP Ordem da Fenix",
                auto = "Jk Roling",
                anoPublicacao = 2004
            )
        )

        println(livros)

O array tem que criar umm novo array com o valor novo, na lista já aceita um valor novo.

Se eu tentar passar um número inteiro aqui, por exemplo, se eu fizer um “livros.add(1)”, ele dá errado. Vamos ver o que
ele vai nos dizer aqui: olhe, o valor inteiro não cabe dentro do tipo “livros”. A função “add” espera um valor do tipo “Livro”. Como função “add”, que ela já estava criada antes de criarmos o nosso tipo “Livro”, sabe que ela espera um valor do tipo “Livro”?
Nós não criamos a função “add”. Ela já existia dentro da “mutableList”. É porque a função “add” vai esperar um valor genérico, do tipo que passarmos aqui. Então sempre que criarmos uma classe, uma estrutura de dados genérica; todas as funções
dela e todos os métodos dela, vão se adaptar ao tipo que passarmos entre maior e menor.
] No caso, é o “Livro”. Então conseguimos adicionar outros livros dentro da nossa lista de livros - coisa que não conseguíamos fazer com o array. 

## Remove
Então criamos uma lista, inicialmente com quatro elementos, e depois adicionamos um quinto elemento. Essa já é uma diferença das listas em relação aos arrays. 
As listas têm tamanho dinâmico; conforme você adiciona elementos, você tem mais elementos. Você pode remover também. Eu posso vir aqui e dar um “remove”: “livros.remove()” e passar, por exemplo, o “(livro1)” aqui.
        
                println(livros)
                livros.remove(livro1)
                println(livros)

                // respostas
                [Livro(titulo=HP pedra filosofal, auto=Jk Roling, anoPublicacao=2000, editora=null), Livro(titulo=HP Camera Secreta, auto=Jk Roling, anoPublicacao=2001, editora=Saraiva), Livro(titulo=HP prisioneiro de Akaban, auto=Jk Roling, anoPublicacao=2002, editora=Saraiva), Livro(titulo=HP Calice de Fogo, auto=Jk Roling, anoPublicacao=2003, editora=Saraiva), Livro(titulo=HP Ordem da Fenix, auto=Jk Roling, anoPublicacao=2004, editora=null)]
                [Livro(titulo=HP Camera Secreta, auto=Jk Roling, anoPublicacao=2001, editora=Saraiva), Livro(titulo=HP prisioneiro de Akaban, auto=Jk Roling, anoPublicacao=2002, editora=Saraiva), Livro(titulo=HP Calice de Fogo, auto=Jk Roling, anoPublicacao=2003, editora=Saraiva), Livro(titulo=HP Ordem da Fenix, auto=Jk Roling, anoPublicacao=2004, editora=null)]
E se imprimirmos de novo a nossa lista de livros, vamos ter removido o “livro1”. Então, a lista mutável, ela é dinâmica. Olhe, o primeiro livro, que era “Grande Sertão: Veredas”, ele já não está mais na segunda lista e é a mesma lista. Estamos modificando ela, ela é mutável, isso já é uma diferença das listas em relação aos arrays.

## Imprimindo listas formatadas
Vamos criar então uma forma de imprimirmos os nossos livros de maneira mais fácil de enxergarmos o que está acontecendo, o que temos de livros. Vamos criar uma “extension function” de “MutableList”.

Criar uma “extension function” da lista de livros - “fun Mutable“. Podemos imprimir uma lista de livros com os marcadores, com hífen para indicarmos cada livro. Colocamos o título e o autor, nós imprimimos de uma maneira mais legal de vermos. Vamos chamar “imprimeComMarcadores()”, essa função não vai retornar nada e vamos imprimir um valor no console só.


                    fun MutableList<Livro>.imprimeComMarcadores(){
                    
                    }

 Então temos “this”, que representa a nossa lista de livros e vamos usar o método da “MutableList”, que chama “joinToString()”. O “joinToString” vai receber uma função onde vai ter cada elemento do livro e nós vamos decidir como queremos imprimir cada linha do livro, ou seja, cada elemento do livro dentro dessa nossa lista de livros.
 Então podemos definir aqui, por exemplo, um “separador”.
 Vamos definir aqui um “(separador =)”. Para cada elemento de livro, eu vou ter um separador. No caso, qual separador eu quero? Eu quero pular uma linha entre um livro e outro, então nós vamos ter uma lista de livros sendo exibida ali, realmente. 
 
            fun MutableList<Livro>.imprimeComMarcadores(){
                val textoFormatado = this.joinToString(separator = "\n") {
                    " - ${it.titulo} de ${it.autor}"
                }
            
                println(" ###### Lista de Livros ###### \n$textoFormatado$")
            }
            // na main
        
            livros.imprimeComMarcadores()

            livros.remove(livro1)
        
            livros.imprimeComMarcadores()

            // resultado

            ###### Lista de Livros ###### 
            - HP pedra filosofal de Jk Roling
            - HP Camera Secreta de Jk Roling
            - HP prisioneiro de Akaban de Jk Roling
            - HP Calice de Fogo de Jk Roling
            - HP Ordem da Fenix de Jk Roling

            ###### Lista de Livros ###### 
            - HP Camera Secreta de Jk Roling
            - HP prisioneiro de Akaban de Jk Roling
            - HP Calice de Fogo de Jk Roling
            - HP Ordem da Fenix de Jk Roling


### Ordenando listas
Tem uma função das listas, que é a função “sorted”. Vamos fazer aqui: “livros.sorted()”. A função “sorted” vai trazer a nossa lista ordenada a partir de algum critério. Qual critério? Não sabemos ainda, por isso que ele está acusando que temos um problema
nós não conseguimos chamar essa função porque, como ele está dizendo aqui, o tipo “Livro” não é um subtipo de “Comparable” de “livros”.
Ou seja, para conseguirmos definir um critério, uma forma de ordenação do nosso objeto livro, temos que ir na nossa classe “Livro” e implementarmos/estendermos o tipo “Comparable” e implementarmos um método “compareTo”,
que é responsável por definir como vamos ordenar as nossas listas.
Então vamos implementar aqui, vamos corrigir o porquê dessa função estar dando erro. Então vamos na classe “Livro” e vamos estender o tipo “Comparable.

            data class Livro(
                val titulo: String,
                val autor: String,
                val anoPublicacao: Long,
                val editora: String? = null
            ): Comparable<Livro>  // a implementacao

A partir do momento que estendemos, ele acusa erro aqui, porque não implementamos os métodos. Clicar alt + enter  Vamos apertar as teclas “Alt + Enter” e ele vai dar a opção “Implement members”, “compareTo(other:Livro):Int”. Ele 
já vai nos trazer o esqueleto do método “compareTo”, que é o método vai ser responsável por ordenar os nossos livros.

            data class Livro(
                val titulo: String,
                val autor: String,
                val anoPublicacao: Long,
                val editora: String? = null
            ): Comparable<Livro> {
                    override fun compareTo(other: Livro): Int {
                    TODO("Not yet implemented")
                }
            }       

Vamos ordenar nossa ordens de livros pelo ano de publicação. Então, “return” - como vamos ordenar a partir de um atributo da classe “Livro” do tipo “Long”. O “Long” já implementa o “compareTo”.

O “Long” já é um “comparable”. Podemos delegar isso para a própria implementação do “Long”, de “compareTo”. Como fazemos isso? Então vamos pegar o “return this.anoPublicacao.compareTo(other.anoPublicacao)”.
Esse “other” então vai ser o livro com o qual vamos comparar esse livro, então “this” “compareTo(other)”.
Estamos delegando a implementação do nosso método “compareTo” para o método “compareTo” do “Long” de “anoPublicacao”, que já implementa uma forma de ordenarmos números do tipo “Long”.

Então ficará assim: 

            package br.com.projetos.estudos.listas

            data class Livro(
                val titulo: String,
                val autor: String,
                val anoPublicacao: Long,
                val editora: String? = null
                ): Comparable<Livro> {
                override fun compareTo(other: Livro): Int {
                    return this.anoPublicacao.compareTo(other.anoPublicacao)
                }
            }

Na main criamos pra imprimir assim:

             val ordenadoAnoPublicacao: List<Livro> = livros.sorted()

             ordenadoAnoPublicacao.imprimeComMarcadores()

Pra utilizar o imprimeComMarcadores o tipo `fun MutableList<Livro>.imprimeComMarcadores()` muda pra `fun List<Livro>.imprimeComMarcadores()` fica funcionando para o MutableList também.

Mas e se quisermos imprimir ordenando por título, por exemplo?

Podemos usar uma outra função `sortedBy{}`. Na “sortedBy” recebe uma função que nos diz o critério de ordenação. Então podemos simplesmente colocar aqui “{it.titulo}”
Olhe só, que simples! Usando “sortedBy” isso aqui já vai nos retornar a mesma coisa que a função “sorted”, só que podemos dizer na hora de chamarmos a função o critério de ordenação que vamos usar. 
Ele já vai usar como parâmetro esse atributo da classe “Livro” para ordenar a nossa lista de livros. Então podemos colocar aqui “val ordenadoPorTitulo = livros.sortedBy { it.titulo }”.

E abaixo vai ser as implementações na main pra ordenar por tipo que eu quero, seja titulo, autor ..


            val ordenadoAnoPublicacao: List<Livro> = livros.sorted()

            ordenadoAnoPublicacao.imprimeComMarcadores()
            
            val ordenadoPorTitulo: List<Livro> = livros.sortedBy { it.titulo }
            ordenadoPorTitulo.imprimeComMarcadores()
            
            livros.sortedBy { it.autor }.imprimeComMarcadores()

## Filtrando listas

Caso queira filtar os livros que tenha apenas um nome de certo autor, eu uso o filter:

            ListaDeLivrosNovas.filter { it.autor == "Nops 1" }

* it referencia a propria função, como se fosse this de uma classe e vou usar o `imprimeComMarcadores()` para imprimir e tratar nossa formatação.
Então fica assim:
            
             ListaDeLivrosNovas.filter { it.autor == "Nops 1" }.imprimeComMarcadores()
e se caso quero pegar e ordernar pelo ano de publicação, acrescento o sortedBy:

        
            ListaDeLivrosNovas.filter { it.autor == "Nops 1" }
                .sortedBy { it.anoPublicacao }
                .imprimeComMarcadores()

Podemos fazer, por exemplo: no autor, conseguimos usar uma função que se chama “startsWith()”. 
A função “startsWith” vai esperar um parâmetro do tipo string – deixe-me apagar aqui. Ela vai esperar um parâmetro do tipo string, que ela vai verificar se é string, se autor começa com determinada string.

Então nós podemos colocar aqui, por exemplo, só “João”. Ao invés de verificarmos se o nome do autor é exatamente “João Guimarães Rosa”, eu vou verificar se o nome do autor começa com “João”.

            
        ListaDeLivrosNovas.filter { it.autor.startsWith("João") }
            .sortedBy { it.anoPublicacao }
            .imprimeComMarcadores()
Eu posso, por exemplo, eu quero pegar só os títulos dos livros. Ao invés de imprimir, eu vou pegar os títulos dos livros. Como eu faço isso?

Uso função map  A função “map”, como já utilizamos antes, é uma função que me diz como vou transformar a minha lista de livros. Eu quero transformar a minha lista de livros em uma lista de títulos. Então é só eu pegar o meu livro, “.titulo” e agora, ao invés de ter uma lista de livros,
eu vou ter uma lista de string com os títulos dos livros.
Podemos pegar aqui! Agora não conseguimos usar o “imprimeComMarcadores”, porque o “imprimeComMarcadores” espera imprimir uma lista de livros. Não temos mais uma lista de livros aqui, o que temos é uma lista de strings.
Vou atribuir a uma variavel titulos e imprimir:

             val titulos: List<String> = ListaDeLivrosNovas.filter { it.autor.startsWith("João") }
                .sortedBy { it.anoPublicacao }
                .map { it.titulo }
        
             println(titulos)

             // resultado

            [As tran�as do rei careca, As muralhas]


## Lidando com nulos

Vamos criar uma lista que agora iremos ter valores null que sao nulos.

        val ListaDeLivrosComNulos: MutableList<Livro?> = mutableListOf()

Vamos criar um arquivo para trabalharmos com essa lista de nulos. “ListaDeLivrosComNulos”, “main”. Para usarmos a nossa lista de livros e testarmos aqui, vamos pegar aquela função “.imprimeComMarcadores()”, vamos separar ela em um outro arquivo.
        
        fun main(){
            ListaDeLivrosComNulos.imprimeComMarcadores()
        }

Se tentarmos chamar, vamos ver que o IntelliJ não está completando para nós aqui. “imprim”... - como é que ela chama? “.imprimeComMarcadores()”. Vamos tentar colocar aqui até o final, não estou acreditando que o IntelliJ não está achando. 
Ele não deixa! Ele encontrou a função, ela ficou amarelinha. Ele encontrou a função, mas ele não está compilando. Ele está dando um erro. O que ele está dizendo?
O tipo não bate. Ele está dizendo que a nossa função espera que ela seja chamada para uma listaDeLivros”, mas o nosso tipo é uma “MutableList” de livros com nulos. “MutableList” não é o problema aqui, porque “MutableList” herda de “List”.
Então poderíamos chamar - nós até já chamamos com um “MutableList”, não é um problema. O problema é o nosso “livro” com “nullable”, o nosso “livro” que pode ser um nulo.

Então na classe fun List<Livro?>.imprimeComMarcadores(){} o List<Livro?> vai ter o `?` que é o safe call.

Só que na função imprimeComMarcadores() o titulo e autor vai começar a reclamar. O “it”, qual é o tipo do “it”? É “Livronullable”, então o “it” pode ser nulo. Se o “livro” pode ser nulo, eu não posso simplesmente chamar o título ou chamar o autor, 
porque eu posso ter um [LOOPHOLE INTEREXCEPTION] aqui.

Para eu conseguir compilar esse código, eu tenho uma forma que é usar a “safe call”. O que é a “safe call”? Eu estou dizendo para o compilador: “olhe, só chame o título ou o autor quando o livro não for nulo”.
É uma forma do Kotlin de saber quando ele chama o título, ou não. Então só chama quando não for nulo. Se for nulo, ele vai retornar o resultado da minha expressão, como um todo, vai ser “null”.
Ele vai retornar um “null”, mas ele não vai tentar chamar o título e não vai dar [LOOPHOLE INTEREXCEPTION].

A modificação no autor e titulo:


        fun List<Livro?>.imprimeComMarcadores(){
            val textoFormatado = this.joinToString(separator = "\n") {
                 " - ${it?.titulo} de ${it?.autor}"
            }
            
            println(" \n ###### Lista de Livros ###### \n\n$textoFormatado")
        }

Mas o que ele colocou aqui? Quando o “livro” foi nulo, ele colocou “null de null”. Ao invés de imprimir o título, “de ” e o nome do autor, como ele não tinha como saber, ele só retornou a expressão nula.

         ###### Lista de Livros ###### 

          - Sr dos Aneis de Nops 1
          - Sr dos Aneis 5 de Nopseira 2
          - null de null // null de null
          - A terra dos que n foram de Nops 1
          - A terra dos que n foram de Nops 1
          - As tran�as do rei careca de Jo�o
          - As muralhas de Jo�o

Mas não fica legal, podemos melhorar colocando um filter na função imprimeComMarcadores()

        fun List<Livro?>.imprimeComMarcadores(){
            val textoFormatado = this
                .filter { it != null } // entra aqui ou 
                .joinToString(separator = "\n") {
                " - ${it?.titulo} de ${it?.autor}"
            }
        
            println(" \n ###### Lista de Livros ###### \n\n$textoFormatado")
        }

ou podemos usar o .filterNotNull(), que é uma chamada na qual o Intellij ja conhece, ai o safe call a ? é retirado do it.titulo e do it.autor.

        fun List<Livro?>.imprimeComMarcadores(){
            val textoFormatado = this
                .filterNotNull()
                .joinToString(separator = "\n") {
                " - ${it.titulo} de ${it.autor}"
            }
        
            println(" \n ###### Lista de Livros ###### \n\n$textoFormatado")
        }


## Lidando com atributos nulos
Quero agrupar a lsita de livros pelo atributo editora e como realizamos isso? Como fazemos para agrupar os nossos livros por algum atributo deles? Podemos usar a função “groupBy”. Então vamos aqui pegar a nossa lista de livros, a “listaDeLivros” 
normal mesmo, sem elementos nulos.
E vamos usar a função “.groupBy{}”. A função “groupBy” espera uma função aqui dentro que diga qual é o elemento que nós vamos usar para agrupar a nossa lista. No caso, vamos agrupar pelo elemento editora, pelo atributo “editora”. 
O atributo “editora” vai ser a chave do nosso agrupamento. O “groupBy” vai nos retornar um mapa. Aqui, olhe, é um mapa de “K” para “List“! O que isso quer dizer?
Ele tem um tipo de objeto que tem uma chave. Esse “K” vem de “key”. Ele vai ter uma chave e cada chave aponta para uma lista de “T”, que no caso é o livro. Então vamos ter um mapa aqui, com uma chave e uma lista de livros para imprimirmos.
Então vamos imprimir a chave, que é a própria editora, que é o que passamos aqui. Para cada editora, vamos ter uma lista de livros que é daquela editora.

Então vamos usar a função “.forEach{}” para definirmos e navegarmos nesse nosso mapa. Então, como vamos saber aqui? Vamos colocar entre parênteses quais são os parâmetros que a nossa função “forEach” recebe - que são a “(editora,” e os “, livros)”.
Para cada um, vamos imprimir uma linha aqui, “println()” para imprimirmos uma linha, contendo o nome da editora. O nome da editora é o que está na nossa chave, “(“$editora: “). Podemos pôr dois pontos aqui para separar o nome da editora dos títulos dos livros e imprimiremos
os títulos dos livros. No título do livro podemos pegar “: livros.joinToString{}” e agora imprimimos os títulos, “{it.titulo}”.

] O que eu estou fazendo aqui então? Estou agrupando a nossa lista de livros por editora. O “groupBy” me retorna um mapa contendo uma chave, que no caso é o próprio nome da editora, que é o atributo que usamos para fazer o agrupamento; e um valor, que é a nossa própria lista de livros. 
Só que não é a nossa lista de livros inteira. Para cada execução do “forEach”, a nossa lista de livros vai conter só os livros que são daquela determinada editora.


            fun main(){
                ListaDeLivrosNovas.groupBy { it.editora }
                     .forEach { (editora, livros) ->
                        println("Nome $editora: ${livros.joinToString { it.titulo }}")
                     }
            }

            // resultado
            Nome Saraiva: Sr dos Aneis
            Nome null: Sr dos Aneis 5, A terra dos que n foram, A terra dos que n foram, As tran�as do rei careca, As muralhas

Só para deixarmos explícitos os tipos dos nossos parâmetros. A editora pode ser nula. E o que ele faz quando é nula aqui? Ele imprime “null”.
Podemos fazer, de repente, ao invés de passarmos quando fazemos o “groupBy”, ao invés de agruparmos por editora mesmo quando a editora for nula; podemos jogar um valor padrão quando o elemento for nulo.
35] Como fazemos isso? Podemos usar o Elvis Operator. O Elvis Operator é um operador do Kotlin que vai te dar uma condição para jogar um valor diferente quando o valor à esquerda do operador for nulo.

` Ele chama Elvis Operator porque ele parece um rostinho, um emoji com topete. Aqui são os olhos e o topete. Ele se chama Elvis Operator. Aqui eu posso colocar um valor padrão para quando a editora for nula. Então eu posso chamar aqui: “: “Editora desconhecida”}” - não sei qual é o nome da editora, então vou chamar de editora desconhecida.`

* Então toda vez que tiver um elvis operation e a condição foir nula, ele joga a opção da direita do elvis ?:.

          fun main(){
              ListaDeLivrosNovas.groupBy { it.editora ?: "Editora Desconhecida"}
                   .forEach { (editora: String, livros: List<Livro>) ->
                       println("Nome $editora: ${livros.joinToString { it.titulo }}")
                   }
          }
    

          // resultados
          Nome Saraiva: Sr dos Aneis
          Nome Editora Desconhecida: Sr dos Aneis 5, A terra dos que n foram, A terra dos que n foram, As tran�as do rei careca, As muralhas

## Lidando com mutabilidade

Vamos organizar e jogar em uma classe:

Genero e o nome da lista:


            data class Prateleira(
              val genero: String,
              val livros: MutableList<Livro>
            ){
              fun organizarPorAutor(): MutableList<Livro> {
                livros.sortedBy { it.autor }
                return livros
              }
            
              fun organizarPorAnoPublicacao(): MutableList<Livro>{
                 livros.sortedBy { it.anoPublicacao }
                 return livros
              }
            }

Na chamada main:

            fun main(){
                val prateleira = Prateleira("Literatura", livros = ListaDeLivrosNovas)
            
                prateleira.organizarPorAutor().imprimeComMarcadores()
                prateleira.organizarPorAnoPublicacao().imprimeComMarcadores()

            }

Ou jogar em uma variavel:

            fun main(){
                val prateleira = Prateleira("Literatura", livros = ListaDeLivrosNovas)
            
                val porAutor = prateleira.organizarPorAutor()
                val porAnoPublicacao = prateleira.organizarPorAnoPublicacao()
            
                porAutor.imprimeComMarcadores()
                porAnoPublicacao.imprimeComMarcadores()
            }

O que acontece aqui, quando imprimimos tudo de uma vez, no final? Estamos reimprimindo a mesma lista. 
Como a última função que chamamos foi “organizarPorAnoPublicacao”, as duas listas, que são as duas variáveis, apontam para a mesma lista - que está organizada por “AnoPublicacao”.


## Listas imutáveis
Acabamos de nos encontrar com um problema de mutabilidade. Quando criamos listas, estamos criando sempre listas mutáveis,
que são as listas que permitem que adicionemos ou removamos um elemento e que reordenemos essa lista.

Como podemos resolver?
Como podemos resolver isso, então? Na nossa prateleira estamos usando uma “MutableList”. Como estamos usando uma “MutableList” aqui, acabamos tendo situações em que ao mexermos nessa lista,
podemos afetar outros pontos do nosso projeto que estiverem usando o mesmo objeto.
Podemos evitar esse tipo de problema utilizando, ao invés de uma “MutableList”, uma “List”, uma “List“. A classe “List” é imutável, ela não possui métodos para fazer alteração da lista,
que é o que podemos ver que aconteceu aqui. Ficou vermelhinho porque parou de compilar. A partir do momento que mudamos para “List”, ele não deixa usar o método “sortBy”.

        data class Prateleira(
            val genero: String,
            val livros: List<Livro>
        ){

O método “sortBy” causa efeito colateral, ele altera a própria lista. Como a “List” não possui esses tipos de funções, essas funções que têm efeito colateral, ele nos impede de usarmos.
Se quisermos usar agora uma lista de livros para fazermos isso, temos que usar a função “.sortedBy”.

A função “sortedBy”, ao invés de alterar a própria lista, ela nos retorna uma lista nova.
Podemos chamar de “livrosOrdenados”. Vamos dar um “return” nos “livrosOrdenados”. Vamos mudar esse tipo, porque agora estamos trabalhando com “List”, não estamos mais trabalhando com “MutableList”. 
E dá certo! O IntelliJ nos avisa que não estamos usando essa variável para nada, só estamos retornando.
Então, se apertarmos as teclas “Alt + Enter” aqui, ele vai sugerir para fazermos um “Inline variable”. O “Inline variable” está dizendo que ele vai colocar em uma linha só toda essa execução, ele vai colocar tudo em uma linha só.


            data class Prateleira(
              val genero: String,
              val livros: List<Livro>
            ){
              fun organizarPorAutor(): List<Livro> {
                val livrosOrdenados = livros.sortedBy { it.autor } 
                return livrosOrdenados
              }
            }

ou 

            fun organizarPorAutor(): List<Livro> {
                return livros.sortedBy { it.autor }
            }
Estamos usando a nossa “listaDeLivros”, passando para o “sortedBy”, criamos uma nova lista de livros ordenada por autor e retornamos essa lista nova. Vamos fazer a mesma coisa no “PorAnoPublicacao”.
Vou apagar tudo aqui. Nós colocamos aqui: “return livros.sortedBy”, porque ele não tem mais a opção de usar o “sortBy”. O “sortBy” é uma função que só está presente para “MutableList”.
  
            data class Prateleira(
                val genero: String,
                val livros: List<Livro>
            ){
              fun organizarPorAutor(): List<Livro> {
                return livros.sortedBy { it.autor }
              }
            
              fun organizarPorAnoPublicacao(): List<Livro>{
                 return livros.sortedBy { it.anoPublicacao }
              }
            }

Aparentemente está tudo compilando, não tem nenhum problema! Apesar de isso aqui ser uma “MutableList”, estamos atribuindo a “MutableList” para um tipo de variável que não é mutável.
Então, internamente, sabemos que o que estamos usando aqui é uma lista mutável, mas agora, ao invés de ficarmos modificando ela, como utilizamos uma interface imutável na nossa prateleira; 
não conseguimos usar funções que modificam a nossa lista. Então estamos seguros que toda vez que organizarmos a nossa lista, estamos na verdade retornando uma lista nova de livros para nós. 
Então essas variáveis agora estão apontando para objetos diferentes.

Então cada uma das nossas variáveis aponta para objetos diferentes. Então mesmo que eu chame novamente a função de organizar, não terá problema, porque não vai afetar o objeto que eu salvei na variável “porAutor”.
Ele vai criar um objeto novo, organizado de uma forma diferente. Quando eu chamar aqui “porAutor.imprimeComMarcadores()”, a função “imprimeComMarcadores()” do “porAutor”, ainda continua organizado por autor, 
porque a função “organizarPorAnoPublicacao” foi chamada, criou um objeto diferente e não alterou o objeto que passamos aqui por parâmetro para ela - que é esse objeto “livros” da nossa classe “Prateleira”.


* Qual é a diferença entre as duas funções sortBy e sorteBy?
    - A função sortBy reorganiza os elementos da coleção que a invocou de acordo com um critério, enquanto a função sortedBy cria uma nova coleção ordenada de acordo com um critério, poupando a lista original.
    - A função sortBy manipula a coleção que invocou a função e, por isso mesmo, só está presente em coleções mutáveis, já a função sortedBy cria uma nova coleção sem interferir no objeto que invoca a função.

