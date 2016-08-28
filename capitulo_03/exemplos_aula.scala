//Introdução ao Specs2

"minha calculadora" >> {
  "somar 2 + 2 e obter 4" >> {
    new Calculadora().somar(2, 2) must_== 4
  }
}

//

//imports necessarios
import org.specs2.mutable.Specification
class MinhaSpec extends Specification {
  "nome da spec" >> {
    //bloco de códico com os exemplos desejados
    "descrição da operação e resultado esperado" >> {
      //bloco de código que executa a classe sob teste
    }
  }
}

//

//imports necessarios
import org.specs2.mutable.Specification
import org.specs2.specification.Scope

class MinhaSpec extends Specification {

  //cada teste cria uma nova instância
  "minha calculadora" >> {
    "somar os numeros" >> new CalculadoraScope {
      calc.soma(1, 2) must_== 3
    }
    "subtrair os numeros" >> new CalculadoraScope {
      calc.soma(10, 2) must_== 8
    }
  }

  trait CalculadoraScope extends Scope {
    val calc = new Calculadora
  }
}

//

//cada teste utiliza a mesma instância
"minha calculadora" >> {

  val calc = new Calculadora

  "somar os numeros" >> {
    calc.soma(1, 2) must_== 3
  }
  "subtrair os numeros" >> {
    calc.soma(10, 2) must_== 8
  }
}

//~test

[info] CalculadoraSpec
[info]
[info] minha calculadora
[info]   + somar os numeros
[info]   + subtrair os numeros
[info]
[info]
[info] Total for specification CalculadoraSpec
[info] Finished in 31 ms
[info] 2 examples, 0 failure, 0 error
[info]
[info] Passed: Total 2, Failed 0, Errors 0, Passed 2
[success] Total time: 4 s, completed 27/08/2016 18:42:55

//
