object Calculadora {

  def soma(x: BigDecimal, y:BigDecimal): BigDecimal = x + y
  def subtrai(x: BigDecimal, y:BigDecimal): BigDecimal = x - y
  def multiplica(x: BigDecimal, y:BigDecimal): BigDecimal = x * y
  def divide(x: BigDecimal, y:BigDecimal): BigDecimal = x / y
  def modulo(x: BigDecimal, y:BigDecimal): BigDecimal = x % y

  def + = soma _
  def - = subtrai _
  def * = multiplica _
  def / = divide _
  def % = modulo _

}

println("Calculadora...")

val num1 = args(0).toInt
val num2 = args(2).toInt
val valor = args(1) match {
  case "+" => Calculadora.+(num1, num2)
  case "-" => Calculadora.-(num1, num2)
  case "*" => Calculadora.*(num1, num2) //erro, terminal> scala Calculadora.scala 2 "*" 4
  case "/" => Calculadora./(num1, num2)
  case "%" => Calculadora.%(num1, num2)
  case _ => println("Operação inválida!")
}

println(s"Valor: $valor")
