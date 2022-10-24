<h1>Arrays Listas</h1>

## Kotlin Arrays e listas

Vamos criar um array com 4 elementos e vai ser um array de inteiro.
Então para criar é: `IntArray(4)`, esse `4` é o tamanho do array, precisamos de inicio o tamanho do array,
pois depois não há como mudar.

Exemplo de construção de array:

            val idades = IntArray(4)
            idades[0] = 25
            idades[1] = 19
            idades[2] = 33
            idades[3] = 20


## Iterando por um array

            val idades = IntArray(4)
            idades[0] = 25
            idades[1] = 19
            idades[2] = 33
            idades[3] = 20

            var maiorIdade = 0  // ou  var maiorIdade = Int.MIN_VALUE
            for(idade in idades){
                if(idade > maiorIdade) {
                    maiorIdade = idade
                }
            }
            println(maiorIdade)


Pra não ficar passando valores conforme anterior, podemos passar direto no `intArrayOf(25, 19, 33, 20, 44, 40)`, exemplo:

        
                                 val idades = intArrayOf(25, 19, 33, 20, 55, 40)

                                 var maiorIdade = 0
                                 for(idade in idades){
                                    if(idade > maiorIdade) {
                                        maiorIdade = idade
                                    }
                                 }
                                 println(maiorIdade)


ou colocando o: `val idades: IntArray = intArrayOf(25, 19, 33, 20, 55, 40)`

Podemos usar o metodo forEach ao inves do for, vamos usar exemplo para encontrarmos a menor idade, pra isso, teremos que
criar uma variável var menorIdade, onde tem que ter um valor maior e pra isso para garantirmos que ela sempre vai
começar com o maior valor possível, podemos usar o “Int.MAX_VALUE”. É uma constante que tem o maior valor possível 
do inteiro. Então qualquer idade que colocarmos aqui, mesmo que seja cento e tantos anos, vai ser menor do que esse
primeiro valor.


                            var menorIdade = Int.MAX_VALUE
                            idades.forEach { idade ->
                                if (idade < menorIdade){
                                menorIdade = idade
                                }
                            }
                            println(menorIdade)

## Alterando um elemento

ara criarmos um array que aceite ponto flutuante nós temos que criar um array de um tipo de ponto flutuante. O array é
bem rígido nesse sentido, você tem que criar um array do tipo que você precisa, um array de um tipo específico para cada
tipo de variável que você vai usar.
Um array de ponto flutante é o doubleArrayOf(1500.00, 300.00, 200.0, 100.00)

Exemplo: 

                 val salarios: DoubleArray = doubleArrayOf(15500.05, 2000.40, 2000.00) ou

                 val salarios = doubleArrayOf(1550.05, 2000.40, 2000.00)

Calculo para aumento do salario:

                    val salarios: DoubleArray = doubleArrayOf(1550.05, 2000.40, 2000.00)

                    val aumento = 1.1
                    var indice = 0
                    for(salario in salarios){
                        salarios[indice] = salario * aumento
                        indice++
                    }
                    println(salarios.contentToString())


* .contentToString()” para pegarmos os valores de cada salário e imprimirmos se não ele sai um valor sem ser a impressão.
Só que o intellij reclama do indice, podemos realizar diferente:
        

                    val salarios: DoubleArray = doubleArrayOf(1550.05, 2000.40, 2000.00)

                    val aumento = 1.1
                    
                    for(indice in salarios.indices){
                        salarios[indice] = salarios[indice] * aumento
                    }
                    println(salarios.contentToString())

Da mesma forma que usamos o “forEach”, anteriormente, para trabalharmos com o array de “idades”, também temos uma 
função “forEachIndexed”, que conseguimos fazer mais ou menos a mesma coisa aqui.

Então poderíamos fazer “salarios.forEachIndexed()”. O “forEachIndexed” é uma função que vai receber como parâmetro uma
outra função, que podemos rodar aqui. Essa função recebe dois argumentos, um desses argumentos é o índice e o outro é o
“salario” em si.

Mas, na hora de fazermos a conta, podemos usar o próprio “salario”, ao invés de usarmos a posição. 
“salarios[i] = salario* aumento”. Aqui estamos fazendo basicamente a mesma coisa, a diferença é que temos o “salario” 
aqui para usarmos, ao invés de termos que acessar de novo pela posição.
O “salario” que vamos usar para fazer a conta, nós não vamos mudar esse “salario”, então podemos usar esse valor
imutável que recebemos na função. Mas na hora de atribuirmos, precisamos ter uma variável mutável aqui - que é, no caso,
a posição do nosso array, o array na posição que queremos alterar.


                            val salarios: DoubleArray = doubleArrayOf(1550.05, 2000.40, 2000.00)
                        
                            val aumento = 1.1
                        
                            salarios.forEachIndexed { indice, salario ->
                                salarios[indice] = salario * aumento
                            }
                            println(salarios.contentToString())


* Arrays com strings
val contatos = arrayOf("Roberto", "Ana", "Paula")
Essa é uma forma bem concisa de construir e atribuir um array de Strings em Koltin.

Outro exemplo:

            val contatos: Array<String> = Array<String>(3) { "" }
            
            contatos[0] = "Roberto"
            
            contatos[1] = "Ana"
            
            contatos[2] = "Paula"

Essa é uma forma bastante de longa e verbosa de construir um array de Strings em Kotlin, mas ela funciona perfeitamente.

## Ranges

Nós temos dentro do Kotlin um tipo de variável que se chama “range”. Ela representa uma série, uma sequência.
Você consegue utilizar o “range” para iterar por valores em uma sequência ou em uma progressão.
Por exemplo: se nós quisermos navegar de 1 até 10, conseguimos usar o “.rangeTo()” para criarmos uma série que vai de 1
até 10. “val serie:”, isso aqui é uma variável do tipo “IntRange”, que representa uma série de números inteiros que vai
de “ 1.rangelo(other:10)”. Então nós conseguimos mostrar isso utilizando um “for(s in serie)”, por exemplo. Aqui podemos
imprimir, “print(“$s ”)”, um espaço, rodarmos esse código aqui.



                    val serie: IntRange = 1.rangeTo(10)

                    for(s in serie){
                       println("$s")
                    }

Ele trouxe a nossa série, de 1 até 10. Conseguiríamos também fazer para imprimirmos. Por exemplo: se eu quiser imprimir
os números pares entre uma série, poderia fazer de 0 a 100.
Tem uma outra forma também de criarmos “range”, que é utilizando esse operador “. .” O operador de 2 pontos faz
exatamente a mesma coisa que o método “rangeTo”, a diferença é que ele é um pouquinho mais legal de visualizarmos.
Você consegue bater o olho e já entender que isso aqui é uma série que vai de 0 até 100. Chamamos isso de
“syntactic sugar” (açúcar sintático), que é uma coisa que a linguagem põe só para deixar a linguagem mais bonita e 
visualmente mais interessante.
Não tem nenhuma diferença de performance se você utilizar um ou outro, pode usar o que você preferir. Então isso aqui,
nós podemos fazer, por exemplo, de 0 a 100, com passos de 2 em 2.

                val numeroPares = 0..100 step 2
Isso aqui vai nos gerar uma série de números, que vão variar entre 0 e 100, de 2 em 2, então serão números pares. 
Podemos atribuir aqui “val numerosPares = 0. .100 step 2”.

               
                0..100 step 2.val // vai aparecer val e aonde vc quer atribuir o nome da variavel se é na expressão toda
                ou no 2 e ai vc define o nome, escolhi na expressão toda que ficou que nem anterior:
                val numeroPares = 0..100 step 2

Ai fica numero pulando de dois em dois:

                    val numeroPares = 0..100 step 2
                    for (numeroPar in numeroPares){
                        println(numeroPar)
                    }

A until quer dizer que vc quer uma serie de 2 ate o 100, no until(100) voce passando, quer dizer que não deseja incluir 
o 100:

                    val numeroPares = 2.until(100) step 2

Temos tambem jeito de fazer valores reverso usando o `downTo`:

                    val paresReverso = 100 downTo 0 step 2
                    paresReverso.forEach{ println(it) }  // o it referencia a si proprio(propria variavel)..
                    ou println("$it")

Próximo exemplo é pra ver se tem o numero passado entre aqueles valores passados:


                        val intervalo = 1500.0..5000.0
                        val salario = 5001.0
                    
                        if(salario in intervalo){
                            println("Esta dentro do intervalo")
                        } else{
                    
                            println("nao esta")
                        }

Acarcteristica de intervalo não serve so pra valores numericos, serve pra strings/letras:

                            val alfabeto = 'a'..'z'
                            val letra = 'k'
                        
                            if(letra in alfabeto){
                                println("K esta dentro de a a z")
                            } else {
                                println("Não esta")
                            }

Lembrando que este range é de letra minuscula, se tiver um K maiusculo ele vai da que não esta pq o a..z, é letras minuscula.

## Operações agregadoras

Ao inves de atribuir uma array de idades e ver quem a maior em um for, ou for each, podemos utilizar o max(), esse metodo,
ira fazer com que devolva o maior numero dentro daquela array:


                    val idades: IntArray = intArrayOf(10, 12, 18, 33, 40, 67)
                    val maiorIdade = idades.max()
                    println("A maior idade é: $maiorIdade")

                    resultado: A maior idade é 67

Se clicar com a tecla “Ctrl” pressionada e depois clicar com o botão em cima da função max(), ele traz a implementação da 
linguagem para essa função. Olhe só, se você for ver, está bem parecido com o que fizemos aqui.

Agora menor valor:


                        val idades: IntArray = intArrayOf(10, 12, 18, 33, 40, 67)
                        val menorIdade = idades.min()
                        println("A menor idade é: $menorIdade")

                        resultado: A menor idade é 10

* lastIndex = ultimo elemento
* isEmpty() = vazio

Tem outras implemenções como a media das idades que contem no array, utilizando: average()

                        val media = idades.average()
                        println("Media é $media")


                        resultado: Media é 30.0

Podemos referir que o resultado é do tipo Double:

                        val media: Double = idades.average()
                        println("Media é $media")


                        resultado: Media é 30.0

Podemos ver também se as idades no array é maior de idade então se todos os elementos satisfizerem essa operação, a
função “all” vai retornar “true”. Se pelo menos um dos elementos não for e não satisfizer, ela vai retornar “false”. 
Então, por exemplo: “val todosMaiores = idades.all ( it >18 }”. Vamos verificar? “println(“Todos maiores:”)” - é a
pergunta. Imprimimos “$todosMaiores”)” e apertamos as teclas “Shift + F10”.


                       val todosMaiores = idades.all { it > 18 }
                       println("todos maiores? $todosMaiores")

Vai dar false porque não são todos maiores de idade, agora se eu quiser saber se pelo menos um ali é maior, ai fazemos com 
a função `any{}` que ver que um dos valores for maior que 18:

                        val existeMaior = idades.any{ it >=18 }
                        println("Maior de idade $existeMaior")

O resultado vai ser true pq tem alunos maior na lista.

Posso filtrar e trazer os valores que estabelece a condição, so vai passar pra resposta quem favorecer a condição:

                        val maiores = idades.filter { it >= 18 }
                        println("Maiores: $maiores")

                        resultado: Maiores: [18, 33, 40, 67]

Eu poderia usar também, se eu quisesse retornar um valor específico, a função “.find{}”. A função “find” vai encontrar
alguém com determinado valor, por exemplo: “val busca = idades.find { it == 18 }”. Ele vai encontrar alguém com idade 
de 18 na lista e vai retornar. “buscar”. Aqui ele vai fazer uma busca mesmo dentro da lista e vai retornar o primeiro
valor que satisfizer a condição.
                
                        val idades: IntArray = intArrayOf(10, 12, 18, 33, 40, 67)
                        val encontrarValor = idades.find { it >= 18 }
                        println("Busca: $encontrarValor")

                        resultado: Busca: 18

Se passasse it > 18, ele ira imprimir o valor em sequencia de 18, maior que 18 que nessa lista é o 33.


* all = vai retornar “true” quando todos os valores satisfizerem a condição. all { }
* any = vai retornar “true” quando pelo menos um dos valores satisfizer a condição. any { }


## Array de objetos
Não conseguimos criar um tipo de array do tipo BigDecimal, temos que colocar um array com tipo generico que pode ser
qualquer tipo.
Então aqui estamos construindo um array de “BigDecimal”, de cinco elementos, todos inicializados com valores “.ZERO”. 
Vamos confirmar isso? Podemos usar o atalho “.val” para criarmos uma variável de referência aqui. Vamos chamar de
“salarios” porque é o que vamos usar aqui.

ex: Array<T>(5) { BigDecimal.ZERO }  // com bigdecimal fica:


                val salarios = Array<BigDecimal>(5) { BigDecimal.ZERO }
                println(salarios.contentToString())
                
                // resultado
                [0, 0, 0, 0, 0]

com for each:
        
                    val salarios = Array<BigDecimal>(5) { BigDecimal.ZERO }
                    salarios.forEach { valor ->
                        println(valor)
                    }

Então, “salario”. Para construirmos um “BigDecimal” com um valor exato, a forma mais prática de fazermos isso é 
utilizando uma string, então podemos usar uma string com o valor aqui, por exemplo, de “ “1500.55” ”.
E usamos a função “.toBigDecimal()” aqui, que já é uma função da própria string para converter esse valor que está no
formato string para um valor “BigDecimal”. Por que a string é a mais indicada?
Porque o “double” tem aquele problema de arredondamento, então podemos no momento da conversão, se criássemos um tipo 
“double” aqui, por exemplo, podemos até – deixe-me só apagar as aspas aqui. Esse valor poderia ter um problema de
arredondamento imediato e já gerar o problema para o “BigDecimal”.
Então o ideal é usarmos a string aqui mesmo e garantimos que esse valor vai ser exatamente esse valor aqui. Vamos 
acrescentar mais um salário aqui? Depois do “[0]” vem o “[1]”. Opa, é “= “2000.00” “, aspas duplas. “ 
“2000.00”.toBigDecimal()”.


              val salarios = Array<BigDecimal>(5) { BigDecimal.ZERO }
              salarios[0] = "1500.50".toBigDecimal()
              salarios[1] = "2000.00".toBigDecimal()
              println(salarios.contentToString())

                // resuultado
              [1500.50, 2000.00, 0, 0, 0]

Então nós podemos criar aqui “fun bigDecimalArrayOf()” para criarmos no mesmo padrão da linguagem. 
Recebemos um parâmetro do tipo string e agora vamos criar um parâmetro aqui, que vai ser igual a esse aqui.

Recebemos um parâmetro variável de strings aqui como parâmetro. Como esse parâmetro é variável, podemos usar o tipo 
“(vararg)”. O “vararg” é um tipo especial do Kotlin que você consegue passar argumentos variáveis para uma função.

Então eu posso passar duas, três ou quatro variáveis, assim como fazemos com o “doubleArrayOf”.
Podemos passar só dois valores tipo “double”, ele cria um array de dois elementos. Ou podemos passar cinco valores tipo
“double” e ele cria um array de “double” de cinco elementos. É o que queremos fazer aqui também. Então vamos usar 
o “(vararg valores: String)”.

Então, o que temos aqui? Temos um parâmetro, um grupo de variáveis, que vamos passar como parâmetro para essa função.
Então podemos passar dois, três, cinco, dez ou 20 valores. Não importa, qualquer valor que colocarmos aqui, podemos
passar um só. Essa construção aqui vai pegar tudo e colocar em um array de strings por nós.
Então aqui pode ter só um elemento, ou pode ter 20 ou 100 elementos. Vamos retornar um “Array()”.

* Construção da função com recebimento do vararg:

            fun bigDecimalArrayOf(vararg valores: String): Array<BigDecimal> 

O tamanho do array, qual vai ser? O tamanho do array vai variar de acordo com a quantidade de parâmetros que passarmos
aqui nos valores. Então vamos pegar o tamanho de “(valores)” - “(valores)” também é um array, ele também tem o atributo
“.size”. Então se pegarmos “valores.size”, temos a quantidade de parâmetros que foi passada para a nossa função.
E conseguimos inicializar o nosso array de um tamanho dinâmico, de um tamanho variável, de acordo com a quantidade de 
parâmetros que recebermos.

            Array<BigDecimal>(valores.size){}


Vamos inicializar os valores, exemplo anterior inicializamos com BigDecimal.ZERO.
Nós podemos inicializar ele já com os nossos valores de string para “BigDecimal”. Como fazemos isso? Nós conseguimos
pegar o índice do nosso array e utilizá-lo para navegarmos dentro dos valores que estão sendo passados como parâmetro.

Então podemos fazer isso aqui: “valores[i].toBigDecimal()”. O que eu estou fazendo aqui? Eu estou pegando cada valor
desse elemento, acessando a partir de um índice “[i]” e convertendo ele para “BigDecimal”.

Esse índice “[i]” é um índice que o próprio construtor aqui do Kotlin já me fornece. Então, se eu criar um array de dez
elementos, esse “[i]” vai variar entre 0 e 9. É a mesma coisa de pegarmos um array “.indices”, assim como fizemos com os
salários anteriormente.

Então conseguimos utilizar esse índice para navegarmos no array de valores que vamos receber como parâmetro,
convertermos cada um desses valores para “BigDecimal” e criarmos o nosso array de “BigDecimal”.



                      Array<BigDecimal>(valores.size){ i ->
                            valores[i].toBigDecimal()
                      }

Aqui ele até deixou em cinza, o IntelliJ deixou em cinza o tipo, porque quando fazemos essa conversão ele entende que já
deixamos explícito que esse array vai ser um array de “BigDecimal”, então não precisamos colocar o tipo aqui. Mas vamos
deixar, para ficar claro para nós. Esse aqui já é o nosso array, já podemos retornar ele diretamente, “return”.

                  Array<BigDecimal>(valores.size){ i ->
                      valores[i].toBigDecimal()
                  }   // no caso n precisaria desse <BigDecimal>
Construção:

                fun bigDecimalArrayOf(vararg valores: String): Array<BigDecimal> {
                    return Array<BigDecimal>(valores.size){ i ->
                        valores[i].toBigDecimal()
                    }
                }


Completo e ai posso passando mais salarios no construtor:

            import java.math.BigDecimal
            
            fun main() {

                val salarios = bigDecimalArrayOf("1500.50", "2000.00")
                println(salarios.contentToString())
            }
            
            fun bigDecimalArrayOf(vararg valores: String): Array<BigDecimal> {
                return Array<BigDecimal>(valores.size){ i ->
                    valores[i].toBigDecimal()
                }
            }
    
            // resultados 
            [1500.50, 2000.00]


Vamos fazer um .map e vamos retornar um novo array com as condições que iremos estabelecer para certos salarios:

        import java.math.BigDecimal
        
        fun main() {
        
            val salarios = bigDecimalArrayOf("1500.50", "2000.00")
            println(salarios.contentToString())
        
            val aumento = "1.1".toBigDecimal()
        
            val aumentoSalarios = salarios.map { salario -> salario * aumento }
        
            println(aumentoSalarios.toString())

            // resultado 
            [1650.550, 2200.000]
        }
        
        fun bigDecimalArrayOf(vararg valores: String): Array<BigDecimal> {
            return Array<BigDecimal>(valores.size){ i ->
                valores[i].toBigDecimal()
            }
        }

Ou podemos passar o tipo e fazer a conversão para array:


        val aumentoSalarios: Array<BigDecimal> = salarios.map { salario -> salario * aumento }.toTypedArray()

Ali informo que ele vai ser um retorno de um arraay e no final passo como toTypedArray()

Mas no nosso exemplo temos que tratar mais dois salarios que não queremos que ele receba o mesmo aumento e toda vez que 
multiplicarmos um “BigDecimal”, ele vai acrescentando um valor depois da vírgula, por causa dessa multiplicação e não 
queremos isso.
Podemos explicitar a escala que queremos trabalhar, como é centavo, vamos escolher dois e escolher o arrendodamento, fazemos
com o setScale():

    val aumentoSalarios: Array<BigDecimal> = salarios.map { salario -> (salario * aumento).setScale(2, RoundingMode.UP) }.toTypedArray()

Salarios acima de 5000 não quero multiplicar e sim somar:

       val salarios = bigDecimalArrayOf("1500.50", "2000.00", "5000.00", "10000.00")

       val aumento = "1.1".toBigDecimal()
    
       val aumentoSalarios: Array<BigDecimal> = salarios
            .map { salario ->
                if(salario < "5000".toBigDecimal()){
                    salario + "500".toBigDecimal()
                } else {
                    (salario * aumento).setScale(2, RoundingMode.UP)
                }
            }.toTypedArray()
    
       println(aumentoSalarios.contentToString())

        // resultados
        
        [2000.50, 2500.00, 5500.00, 11000.00]


## Somatória com Reduce
Agora o dono da empresa gostou da forma como nós calculamos o aumento do salários dele, tendo um aumento mínimo para os 
funcionários. O que ele precisa agora é de uma forma de saber o quanto ele vai gastar com os funcionários dele neste mês
e o quanto ele vai gastar nos próximos seis meses.

* Primeiro vamos refatorar, jogar em uma função nossa condição:


    private fun calculoAumentoRelativo(salario: BigDecimal, aumento: BigDecimal): BigDecimal {
      return if (salario < "5000".toBigDecimal()) {
        salario + "500".toBigDecimal()
      } else {
        (salario * aumento).setScale(2, RoundingMode.UP)
      }
    }

Para somar vamos desenvolver a nossa própria somatória para o array de “BigDecimals”.

Para criarmos essa função, nesse formato array ponto somatória, temos que criar uma “extension function” de array.
Então podemos vir aqui embaixo e digitarmos: “fun Array”.
Vamos chamar ela de “somatoria()” e ela vai retornar um “BigDecimal”. Dessa forma, fazemos uma “extension function” do
array de “BigDecimal” para podermos chamar ela naquele formato: “salarios.somatoria” e ele retorna a somatória para nós.

Recebemos aqui nessa “extension function” um “Array“, que está vindo aqui antes do ponto. Ele vem para nós como “this”,
é como conseguimos acessar esse array dentro do escopo da função. Então “this” é o meu próprio array de “BigDecimal”. 
Nós vamos ter que retornar um “BigDecimal” aqui. Como fazemos para somar cada valor do nosso array de “BigDecimal”?

O reduce e o que ele faz? Ele já preencheu aqui para mim, eu vou mudar os nomes que ele coloca. Esse “acc” que ele 
colocou é de “accumulator” (acumulador). O “bigDecimal” é o “valor” em questão, que vamos somar

Então o “reduce” recebe uma função que tem como parâmetro um “acumulador” e um “valor” - que é o quê? O “valor” é o 
elemento do array que estamos iterando, então estamos iterando um array de “BigDecimal”, e cada valor do array vem aqui
através desse parâmetro “valor”, desse argumento “valor”. O “acumulador” é a somatória de cada iteração.
Então quando eu faço isso aqui “acumulador + valor”, o que ele está fazendo? Ele vai iterar por cada valor do array. 
A cada valor do array, ele vai somar com o acumulador e passar para a próxima iteração, sempre somando esse acumulador. 
Então o “acumulador” vai começar sendo “0” e vai somar com o primeiro valor do array. Somou o primeiro valor, o
“acumulador” vai ser igual a “0”, mais o valor, e ele vai vir para cá.
Então aqui no nosso caso, no nosso array, ele vai começar com 1500, então vai ser “0”. Próximo valor é de 1500, ele vai 
somar 0 com 1500 e vai salvar o “1500” dentro do “acumulador”.
E isso aqui vai iterando. A cada iteração o “acumulador”, ele vai representar a soma da última iteração. No final de 
todas as operações, o “acumulador” vai ter toda a somatória do nosso array e vai nos retornar isso daí.
Podemos retornar isso diretamente, que ele já vai retornar um “BigDecimal”. Então o “reduce” vai fazer o quê? O que o 
“reduce” está fazendo? Ele vai reduzir todo o nosso array a um valor só.

    
        fun Array<BigDecimal>.somatoria(): BigDecimal {
            return this.reduce { acumalador, valor ->
                acumalador + valor
            }
        }


na main:

        val gastoInicial = aumentoSalarios.somatoria()
        println(gastoInicial)

        // resultado
        21000.50


## Gasto total com Fold
Agora precisamos saber: somado esse gasto inicial com o gasto nos próximos seis meses, quanto o dono da empresa vai
gastar com o salário dos funcionários com esse aumento? “salariosComAumento.fold()”. O “fold” é relativamente parecido
com a função “reduce” que usamos para fazer a somatória. A diferença é que o “fold” recebe um valor inicial, é a 
principal diferença.
Então o “fold”, eu vou colocar como parâmetro dele o nosso “(gastoInicial)”, que é o nosso gasto com o primeiro mês.
E para os gastos seguintes, nós fazemos uma multiplicação do salário com aumento pelos meses que o dono da empresa nos
pediu, que são seis meses.

      
            val meses = 6.toBigDecimal()
            aumentoSalarios.fold(gastoInicial) { acumulador, salario -> 
                acumulador + (salario * meses).setScale(2, RoundingMode.UP)
            }

Assim como no “reduce”, vamos ter aqui também um “acumulador” e um valor, que no nosso caso vai ser um “salario”. Então
recebemos aqui um “acumulador” e um “salario”. Agora precisamos fazer a conta da multiplicação pelos meses que vamos
calcular o aumento para os funcionários.
No caso, vamos colocar aqui fora já a quantidade de “meses”. Ele pediu para os próximos seis meses, então vamos deixar 
aqui seis meses. Então vamos contar o “acumulador”. Sempre que vamos fazer uma somatória, temos sempre que ir incluindo 
o “acumulador” na nossa conta.

Então, o “acumulador + salario * ”, a quantidade de meses. Aqui o “meses” não está - vamos colocar aqui já como 
“BigDecimal”. Pronto! Agora podemos multiplicar aqui diretamente, “acumulador + salario * meses”.

 O setScale() já é pra arredondar.

Então, o que ele vai fazer? Ele vai multiplicar cada um dos salários com aumento pela quantidade de meses, que no caso 
são seis, e vai somar isso com o acumulador.


            val gastoInicial = aumentoSalarios.somatoria()
            println(gastoInicial)
        
            val meses = 6.toBigDecimal()
            val gastoTotal = aumentoSalarios.fold(gastoInicial) { acumulador, salario ->
                acumulador + (salario * meses).setScale(2, RoundingMode.UP)
            }
            println(gastoTotal)

            // resultados
            147003.50


## Compondo operações
Depois que o dono da empresa viu aqui o gasto total dos salários dos funcionários depois do aumento, ele achou um pouco 
alto e queria saber a média dos três maiores salários dos funcionários dele depois do aumento.

Vamos tirar a media de salarios e vamos pegar todos os arrays dos salarios e como achamos a média dos três maiores
salários? Precisamos, antes de tudo, identificarmos quais são os três maiores salários e depois precisamos tirar uma
média deles. Uma das formas que podemos fazer para identificarmos os três maiores salários é simplesmente pegarmos todo 
o array de “salarios” e ordenarmos do menor para o maior.
E podemos pegar os três últimos valores e então vamos saber quais são os três maiores. 

Com sorted() que vai retornar uma lista com todos os valores “BigDecimal”. Aqui no caso o “salarios”, ordenados do menor
para o maior. A ordenação padrão dessa função, já é do menor para o maior. Ela está ordenada, é uma lista.

           aumentoSalarios.sorted()

A partir do momento que temos os salários ordenados, nós precisamos pegar os três últimos salários. Como podemos fazer isso?
Podemos ver o tamanho do array e vermos quais são os três índices, antes e pegarmos um por um. Nós poderíamos fazer
isso, mas tem já uma função do próprio Kotlin, que se chama “take”. Então temos os “salariosOrdenados.take”, que vai
pegar os três valores para nós.
No caso, a função “take” vai pegar os primeiros valores. Então, se eu fizer aqui “.take(3)”, ele vai pegar os três 
primeiros salários para nós. 

         val tresPrimeiros = salariosOrdenados.take(3)
         println(tresPrimeiros)

         // resultados 
         [2000.50, 2500.00, 5500.00] 

Mas não é isso que queremos, nós queremos os três últimos.

Tem uma outra função aqui, que se chama “.takeLast()”. A “takeLast” vai pegar os últimos, é uma função em que ela pega “N”
elementos que nós passarmos. No caso queremos “(n: 3)”. Desses “N” elementos, ela vai pegar para nós os três últimos, no
caso aqui.


            val tresUltimos = salariosOrdenados.takeLast(3)
            println(tresUltimos)

            // resultados
            [2500.00, 5500.00, 11000.00]

Para os arrays primitivos nós temos aquela função “average”.

Vamos criar pro BigDecimal uma função pra calcular a media:

          fun Array<BigDecimal>.media(): BigDecimal {
              return if(this.isEmpty()){
                  BigDecimal.ZERO
              } else{
                  this.somatoria() / this.size.toBigDecimal()
              }
          }

Se o array estiver vazio, nós não tentamos calcular a média então o isEmpty().

Podemos retornar uma lista:

      val tresUltimos: List<BigDecimal> = salariosOrdenados.takeLast(3)

Mas ai podemos passar como array e transformar no final um toTypedArray():

      val tresUltimos: Array<BigDecimal> = salariosOrdenados.takeLast(3).toTypedArray()

Vamos agora calcular a media os três maiores salarios:

      val tresUltimos: Array<BigDecimal> = salariosOrdenados.takeLast(3).toTypedArray()

      val media = tresUltimos.media()
      println(media)

      // resultados
      6333.33

Mas podemos emendar a resposta de uma chamada na outra ao inves de atribuir o sorted() para uma variavel eu ja posso
eu já posso chamar o “takeLast” direto.
Então, por exemplo, vou fazer aqui embaixo: “salariosComAumento.sorted()” - isso aqui já me retorna uma lista ordenada.

              val media = aumentoSalarios.sorted().takeLast(3).toTypedArray().media()
              println(media)
              // resultados
              6333.33