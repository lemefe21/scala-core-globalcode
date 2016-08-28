//Sintaxe e semântica
//Declaração de variáveis

scala> val nome: String = "Leme"
nome: String = Leme

scala> val idade: Int = 30
idade: Int = 30

scala> val valor: Double = 129.90
valor: Double = 129.9

//com inferência de tipos

scala> val nome = "Leme"
nome: String = Leme

scala> val idade = 30
idade: Int = 30

scala> val valor = 219.90
valor: Double = 219.9

//Condições e repetições

scala> val maiorIdade = if(idade > 30) true else false
maiorIdade: Boolean = false

scala> for (x <- 0 to 10)
     | println("x= " + x)
x= 0
x= 1
x= 2
x= 3
x= 4
x= 5
x= 6
x= 7
x= 8
x= 9
x= 10

//Classes e Objetos

class Pessoa
Object Pessoa //Singleton //Estático
//mesmo nome >> Companion Object

scala> class Pessoa {
     | def func = println("Pessoa...")
     | }
defined class Pessoa

scala> object Pessoa {
     | def funcObjeto = println("Objeto...")
     | }
defined object Pessoa
warning: previously defined class Pessoa is not a companion to object Pessoa.
Companions must be defined together; you may wish to use :paste mode for this.

scala> val p = new Pessoa
p: Pessoa = Pessoa@1115ec15

scala> p.func
Pessoa...

scala> Pessoa.funcObjeto
Objeto...

//Utilizando ; e outros simbolos
//simbolos para nomear funções

scala> object Numero {
     | def + = println("Somando número...")
     | def -(x: Int): Int = x - 1
     | }
defined object Numero

scala> Numero +
warning: there was one feature warning; re-run with -feature for details
Somando número...

scala> Numero - 20
res8: Int = 19

//infix notation, função recebe um único parâmetro
scala> nome.charAt(1)
res2: Char = e

scala> nome charAt 1
res3: Char = e

//postfix notation, funções que não recebem parâmetros
scala> nome.size
res6: Int = 4

scala> nome size
warning: there was one feature warning; re-run with -feature for details
res7: Int = 4

//Métodos e funções
//def func(<params>): <tipoRetorno>

scala> def soma(x: Int, y: Int): Int = x + y
soma: (x: Int, y: Int)Int

scala> soma(12, 34)
res8: Int = 46

//escopo flexível para criação de função

scala> def soma(x: Int, y: Int) : Int = {
     | def imprimeX = println("x = " + x)
     | imprimeX
     | x + y
     | }
soma: (x: Int, y: Int)Int

scala> soma(120, 345)
x = 120
res0: Int = 465

//parâmetros nomeados com valores padrão

scala> def soma(x: Int = 10, y: Int = 35) = x + y
soma: (x: Int, y: Int)Int

scala> soma(20)
res5: Int = 55

scala> soma(1, 3)
res6: Int = 4

scala> soma(y = 1000)
res0: Int = 1010

//Funções "normais" call-by-value X call-by-name
//call-by-value

scala> soma(y = 1000)
res0: Int = 1010

scala> def func(avaliar: Boolean, valor: Char) = {
     | if(avaliar) println(valor)
     | else println("Não avaliar...")
     | }
func: (avaliar: Boolean, valor: Char)Unit

scala> func(false, nome.charAt(0))
java.lang.NullPointerException
  ... 32 elided
//toda a expressão é avaliada

//call-by-name

scala> def func(avaliar: Boolean, valor: => Char) = {
     | if(avaliar) println(valor)
     | else println("Não avaliar...")
     | }
func: (avaliar: Boolean, valor: => Char)Unit

scala> func(false, nome.charAt(0))
Não avaliar...

//a expressão só será avaliada no momento em que for acessada

//Interpolação de Strings

scala> val nome = "Leme"
nome: String = Leme

scala> val idade = 30
idade: Int = 30

scala> val mensagem = s"O funcionario ${nome} tem ${idade} anos de idade"
mensagem: String = O funcionario Leme tem 30 anos de idade

scala> println(mensagem)
"O funcionario Leme tem 30 anos de idade"
