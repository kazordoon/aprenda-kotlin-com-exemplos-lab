enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel) {
	val conteudos: MutableList<ConteudoEducacional> = mutableListOf()
    val inscritos = mutableListOf<Usuario>()
    
    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
    }
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    override fun toString(): String {
        var conteudosTexto = ""
        for (conteudo in conteudos) {
            conteudosTexto += "\n\tNome: ${conteudo.nome} / "
            conteudosTexto += "Duração: ${conteudo.duracao}m"
        }
        
        var inscritosTexto = ""
        for (inscrito in inscritos) {
            inscritosTexto += "\n\t${inscrito.nome}"
        }
        
        return """
===================================
Informações sobre a nossa formação
===================================
        
Nome: $nome
Nivel: $nivel
Conteúdos: $conteudosTexto
Estudantes inscritos: $inscritosTexto
        """
    }
}

fun main() {
	val usuario1 = Usuario("Luis")
    val usuario2 = Usuario("Gabriel")
    val usuario3 = Usuario("Raphaela")

    var duracaoEmMinutos = 180
    val pooConteudo = ConteudoEducacional("POO com Kotlin", duracaoEmMinutos)
    val exceptionsConteudo = ConteudoEducacional("Tratamento de exceções com Kotlin")
    
    val formacao = Formacao("Curso de Kotlin", Nivel.BASICO)
    formacao.adicionarConteudo(pooConteudo)
    formacao.adicionarConteudo(exceptionsConteudo)
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario3)
    
	println(formacao)
}
