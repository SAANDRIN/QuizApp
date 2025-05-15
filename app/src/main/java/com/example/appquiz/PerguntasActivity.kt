package com.example.appquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appquiz.databinding.ActivityPerguntasBinding


class PerguntasActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityPerguntasBinding.inflate(layoutInflater)
    }
    private lateinit var listaPerguntas: Array<Pergunta>
    private var indicePerguntaAtual = 1
    private var totalRespostasCorretas = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Carregar lista de perguntas
        listaPerguntas = DadosFicticios.recuperarListaPerguntas()


        // Meus códigos
        val bundle = intent.extras
        val nome = bundle?.getString("nome_usuario") ?: "Nome não identificado"

        with(binding) {

            textNome.text = "Olá, $nome"

            // Exibindo a primeira pergunta
            exibirPerguntaAtual()
            btnConfirmar.setOnClickListener {

                if ( validarRespostasPerguntaAtual() ){

                    verificarRespostaCerta()
                    indicePerguntaAtual++

                    if ( indicePerguntaAtual <= listaPerguntas.size ){

                        exibirPerguntaAtual()

                    } else {

                        val intent = Intent(this@PerguntasActivity, DetalhesActivity::class.java)
                        intent.putExtra("total_respostas", totalRespostasCorretas )
                        startActivity( intent )
                        finish()

                    }

                }

            }


        }
    }

    private fun verificarRespostaCerta() {

        val pergunta      = listaPerguntas[ indicePerguntaAtual - 1 ]
        val respostaCerta = pergunta.respostaCerta

        var respostaSelecionada = if ( binding.rb01.isChecked ){
                                         1
                                    } else if ( binding.rb02.isChecked ){
                                         2
                                    } else if ( binding.rb03.isChecked ){
                                         3
                                    } else {
                                         0
                                    }

        if ( respostaSelecionada == respostaCerta ) {
            totalRespostasCorretas++
        }

        binding.rgRespostas.clearCheck()

    }

    private fun validarRespostasPerguntaAtual() : Boolean {

        with(binding) {

            val resposta01 = rb01.isChecked
            val resposta02 = rb02.isChecked
            val resposta03 = rb03.isChecked

            if ( resposta01 || resposta02 || resposta03 ){

                return true

            }

            Toast.makeText(this@PerguntasActivity, "Escolha uma das alternativas para avançar", Toast.LENGTH_SHORT).show()
            return false

        }

    }

    private fun exibirPerguntaAtual() {

        with( binding ) {

        // Exibir dados da pergunta
        val perguntaAtual = listaPerguntas[ indicePerguntaAtual - 1 ]
        textPergunta.text = perguntaAtual.titulo
        rb01.text = perguntaAtual.resposta01
        rb02.text = perguntaAtual.resposta02
        rb03.text = perguntaAtual.resposta03

        // Exibir dados do contador
        // val contadorPerguntaAtual = indicePerguntaAtual
        val totalPerguntas = listaPerguntas.size
        textContadorPerguntas.text = "$indicePerguntaAtual pergunta de $totalPerguntas"

        }

    }
}