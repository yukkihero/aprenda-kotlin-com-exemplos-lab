enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var nivel: Nivel, var conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome.")
    }

    fun listarConteudos() {
        println("Conteúdos da formação $nome:")
        conteudos.forEach { conteudo ->
            println("${conteudo.nome} - ${conteudo.duracao} minutos")
        }
    }
}

fun main() {
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")

    val conteudo1 = ConteudoEducacional("Introdução à Programação", 90)
    val conteudo2 = ConteudoEducacional("Estruturas de Dados", 120)
    
    val formacao = Formacao("Formação de Kotlin", Nivel.INTERMEDIARIO, mutableListOf(conteudo1, conteudo2))

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    formacao.listarConteudos()
}
