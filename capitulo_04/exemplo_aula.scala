//Introdução a Tipos e Inferência de Tipos
//Tipos

scala> val x = Int.MaxValue + 1
x: Int = -2147483648

scala> val y = Int.MaxValue
y: Int = 2147483647

//Inferência de Tipos

scala> val nome = "Leme"
nome: String = Leme

scala> val idade = 30
idade: Int = 30

scala> val preco = 1.90
preco: Double = 1.9

scala> val precoDesconto = BigDecimal(1.75)
precoDesconto: scala.math.BigDecimal = 1.75

scala> def soma(x: Int, y: Int) = x + y
soma: (x: Int, y: Int)Int

//não consegue inferir o tipo em parâmetros e retorno de funções recursivas

scala> def fatorial(x: Int) = if (x == 1) 1 else x * fatorial(x - 1)
<console>:11: error: recursive method fatorial needs result type
       def fatorial(x: Int) = if (x == 1) 1 else x * fatorial(x - 1)

scala> def fatorial(x: Int): Int = if (x == 1) 1 else x * fatorial(x - 1)
fatorial: (x: Int)Int

//

scala> val numeros = List(1, 2, 3, 4)
numeros: List[Int] = List(1, 2, 3, 4)

scala> val listaMix = List(1, 2, "Leme", 4, 5)
listaMix: List[Any] = List(1, 2, Leme, 4, 5)

// Tipos Estruturais

scala> def processaEFecha[A <: {def close(): Unit}] (recurso: A) (f: A => Any) {
     | try {
     | f(recurso)
     | } finally {
     | println("fechando o recurso")
     | recurso.close()
     | }
     | }
warning: there was one feature warning; re-run with -feature for details
processaEFecha: [A <: AnyRef{def close(): Unit}](recurso: A)(f: A => Any)Unit

scala> val output = new BufferedWriter(new OutputStreamWriter(new ByteArrayOutputStream()))
output: java.io.BufferedWriter = java.io.BufferedWriter@159a48a6

scala> processaEFecha(output) { baos =>
     | baos.write("Escrevendo algo antes de fechar...")
     | }
fechando o recurso

//
