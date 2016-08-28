//Orientação a objetos em Scala

//classe com construtor vazio e sem atributos especificados
scala> class Pessoa
defined class Pessoa

//classe com contrutor com atributo e atributos gerados na classe
//por padrão atributos são imutáveis e privados
scala> class Aluno(nome: String)
defined class Aluno

//atributo imutável, mas publico
scala> class Aluno(val nome: String)
defined class Aluno

//atributo mutável e publico
scala> class Aluno(var nome: String)
defined class Aluno

//

scala> val aluno = new Aluno("Leme")
aluno: Aluno = Aluno@7006c658

scala> aluno.nome
res0: String = Leme

//imutável
scala> aluno.nome = "lemefe21"
<console>:13: error: reassignment to val
       aluno.nome = "lemefe21"
//

scala> class Pessoa(nome:String) {
       //código executado na criação da classe
     | println("Criando um objeto da classe Pessoa")
     | }
defined class Pessoa

scala> val p = new Pessoa("Leme")
Criando um objeto da classe Pessoa
p: Pessoa = Pessoa@6ea12c19

//Construtores auxiliares

scala> class Pessoa(nome: String) {
     | def this() = this("")
     //parâmetros dos construtores auxiliares não se tornam atributos
     | def this(nome: String, sobreNome: String) = this(s"$nome $sobreNome")
     | }
defined class Pessoa

scala> val p = new Pessoa("Felipe", "Leme")
p: Pessoa = Pessoa@70ed52de

scala> p.sobreNome
<console>:14: error: value sobreNome is not a member of Pessoa
       p.sobreNome
         ^
//Objects (Singletons - Métodos Estáticos)

scala> class Pessoa(val nome: String)
defined class Pessoa

scala> object CriadorDePessoas {
     | def criarPessoa(nome: String) = new Pessoa(nome)
     | }
defined object CriadorDePessoas

scala> val p = CriadorDePessoas.criarPessoa("Leme")
p: Pessoa = Pessoa@59d4cd39
//criarPessoa método fábrica >> (apply)

scala> p.nome
res0: String = Leme

//exemplo de companion objects >> List e object List

//Escopo e visibilidade
