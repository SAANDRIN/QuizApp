package com.example.appquiz

class DadosFicticios {

    companion object{

        fun recuperarListaPerguntas() : Array<Pergunta>{

            val pergunta1 = Pergunta(
                1,
                "1) Qual foi a duração do primeiro vídeo do Youtube?",
                "3 minutos", "1 minuto", "18 segundos",
                3
            )
            val pergunta2 = Pergunta(
                2,
                "2) Em média, quantas pesquisas totalmente novas são feitas no Google todo dia?",
                "450 milhões", "1 Bilhão", "10 Bilhões",
                1
            )
            val pergunta3 = Pergunta(
                3,
                "3) Qual foi a primeira rede social da história da internet?",
                "MySpace", "ClassMate", "Orkut",
                2
            )
            val pergunta4 = Pergunta(
                4,
                "4) Quantos Bits cabem em um Byte?",
                "1 bit", "4 bits", "8 bits",
                3
            )

            return arrayOf(
                pergunta1, pergunta2, pergunta3, pergunta4
            )

        }

    }

}