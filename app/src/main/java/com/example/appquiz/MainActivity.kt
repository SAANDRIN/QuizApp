package com.example.appquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {

            btnIniciar.setOnClickListener {

                val nome = editNome.text.toString()

                validacaoNome(nome)

            }



        }

    }
    private fun validacaoNome(nome: String){
        val nome = nome

        if (nome.isNotEmpty()) {
            val intent = Intent(this@MainActivity, PerguntasActivity::class.java)
            intent.putExtra("nome_usuario", nome)

            startActivity(intent)
        } else {
        binding.editNome.error = "Digite o nome para prosseguir"
            Toast.makeText(this, "Preencha o nome", Toast.LENGTH_SHORT).show()
        }

    }
}