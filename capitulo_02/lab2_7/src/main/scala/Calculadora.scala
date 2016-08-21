class Calculadora{

	def soma(x:BigDecimal, y:BigDecimal):BigDecimal = x + y //retorno implicito
	def subtrai(x:BigDecimal, y:BigDecimal):BigDecimal = x - y
	def multiplica(x:BigDecimal, y:BigDecimal):BigDecimal = x * y
	def divide(x:BigDecimal, y:BigDecimal):BigDecimal = x / y
	def modulo(x:BigDecimal, y:BigDecimal):BigDecimal = x % y
	def porcentagem(x: BigDecimal, y:BigDecimal):BigDecimal = x * (y / 100)

	//função aplicada parcialmente
	def + = soma _ //curyng
	def - = subtrai _
	def * = multiplica _
	def / = divide _
	def % = modulo _
	def porc = porcentagem _

}

//companion object
object Calculadora {

	def main(args: Array[String]){

		val num1 = args(0).toInt //int para BigDecimal, tb tem conversor implicito
		val num2 = args(2).toInt

		val calculadora = new Calculadora

		val x = args(1) match {
			case "+" => calculadora.+(num1, num2)
			case "-" => calculadora.-(num1, num2)
			case "*" => calculadora.*(num1, num2) //scala Calculadora.scala 2 "*" 4
			case "/" => calculadora./(num1, num2)
			case "%" => calculadora.%(num1, num2)
			case "porc" => calculadora.porc(num1, num2)
			case _ => println("Operação inválida!")
		}

		println(x)

	}

}

/*
sbt
> run 1 + 2
[info] Running Calculadora 1 + 2
3
[success] Total time: 0 s, completed 21/08/2016 14:09:43
*/

/*
> scalac Calculadora.scala
> javap

Compiled from "Calculadora.scala"

public class Calculadora {
  public static void main(java.lang.String[]);
  public scala.math.BigDecimal soma(scala.math.BigDecimal, scala.math.BigDecimal);
  public scala.math.BigDecimal subtrai(scala.math.BigDecimal, scala.math.BigDecimal);
  public scala.math.BigDecimal multiplica(scala.math.BigDecimal, scala.math.BigDecimal);
  public scala.math.BigDecimal divide(scala.math.BigDecimal, scala.math.BigDecimal);
  public scala.math.BigDecimal modulo(scala.math.BigDecimal, scala.math.BigDecimal);
  public scala.math.BigDecimal porcentagem(scala.math.BigDecimal, scala.math.BigDecimal);
  public scala.Function2<scala.math.BigDecimal, scala.math.BigDecimal, scala.math.BigDecimal> $plus();
  public scala.Function2<scala.math.BigDecimal, scala.math.BigDecimal, scala.math.BigDecimal> $minus();
  public scala.Function2<scala.math.BigDecimal, scala.math.BigDecimal, scala.math.BigDecimal> $times();
  public scala.Function2<scala.math.BigDecimal, scala.math.BigDecimal, scala.math.BigDecimal> $div();
  public scala.Function2<scala.math.BigDecimal, scala.math.BigDecimal, scala.math.BigDecimal> $percent();
  public scala.Function2<scala.math.BigDecimal, scala.math.BigDecimal, scala.math.BigDecimal> porc();
  public Calculadora();
}
*/
