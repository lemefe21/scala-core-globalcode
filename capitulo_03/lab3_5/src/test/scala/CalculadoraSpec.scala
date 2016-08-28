import org.specs2.mutable.Specification
import org.specs2.specification.Scope

class CalculadoraSpec extends Specification {

  "testes da classe calculadora" >> {
    "somar os numeros e obter o resultado esperado" >> new CalculadoraScope {
      calculadora.soma(1, 2) must_== 3
    }
    "somar os numeros e obter o resultado esperado utilizando função parcial" >> new CalculadoraScope {
      calculadora.+(1, 2) must_== 3
    }
    "subtrair os numeros e obter o resultado esperado" >> new CalculadoraScope {
      calculadora.subtrai(10, 2) must_== 8
    }
    "subtrair os numeros e obter o resultado esperado utilizando função parcial" >> new CalculadoraScope {
      calculadora.-(10, 2) must_== 8
    }
    "multiplica os numeros e obter o resultado esperado" >> new CalculadoraScope {
      calculadora.multiplica(3, 5) must_== 15
    }
    "multiplica os numeros e obter o resultado esperado utilizando função parcial" >> new CalculadoraScope {
      calculadora.*(3, 5) must_== 15
    }
    "divide os numeros e obter o resultado esperado" >> new CalculadoraScope {
      calculadora.divide(14, 7) must_== 2
    }
    "divide os numeros e obter o resultado esperado utilizando função parcial" >> new CalculadoraScope {
      calculadora./(14, 7) must_== 2
    }
    "resto/modulo da divisão com os numeros e obter o resultado esperado" >> new CalculadoraScope {
      calculadora.modulo(7, 2) must_== 1
    }
    "resto/modulo da divisão com os numeros e obter o resultado esperado utilizando função parcial" >> new CalculadoraScope {
      calculadora.%(7, 2) must_== 1
    }
    "poscentagem dos numeros e obter o resultado esperado" >> new CalculadoraScope {
      calculadora.porcentagem(200, 10) must_== 20
    }
    "poscentagem dos numeros e obter o resultado esperado utilizando função parcial" >> new CalculadoraScope {
      calculadora.porc(200, 10) must_==20
    }
  }

  trait CalculadoraScope extends Scope {
    val calculadora = new Calculadora
  }

}
