package com.example.appquiz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appquiz.databinding.ActivityDetalhesBinding


class DetalhesActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDetalhesBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bundle = intent.extras

        val respostasCertas = bundle?.getInt("total_respostas") ?: 0

        when (respostasCertas) {
            1 -> binding.textResultado.text = "Resultado: 25%"
            2 -> binding.textResultado.text = "Resultado: 50%"
            3 -> binding.textResultado.text = "Resultado: 75%"
            4 -> binding.textResultado.text = "Resultado: 100%"
            else -> binding.textResultado.text = "Resultado: 0%"
        }

        binding.textTotalRespostas.text = "Respostas corretas: $respostasCertas"

        binding.btnReiniciar.setOnClickListener {
            finish()
        }




    }
}