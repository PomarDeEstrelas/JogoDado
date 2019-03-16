package com.example.logonrmlocal.jogodado

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        btJogar.setOnClickListener {
            realizarJogada()
        }
    }

    fun realizarJogada() {
        val jogador = gerarNumero()
        val adversario = gerarNumero()

        configuraImagemDoDado (jogador, ivJogador)
        configuraImagemDoDado (adversario, ivAndroid)

        verificaVencedor(jogador, adversario)
    }

    fun exibeMensagem(mensagem: String) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show()
    }

    fun verificaVencedor(numeroJogador: Int, numeroAdversario: Int){
        if(numeroJogador < numeroAdversario){
            exibeMensagem("Perdeu")
        }

        else if(numeroJogador > numeroAdversario){
            exibeMensagem("Ganhou")
        }

        else {
            exibeMensagem("Empatou")
        }
    }

    

    fun configuraImagemDoDado(numeroDado: Int, imageView: ImageView){
        when (numeroDado){
            1-> (setImagem(imageView, R.drawable.dado_1))
            2-> (setImagem(imageView, R.drawable.dado_2))
            3-> (setImagem(imageView, R.drawable.dado_3))
            4-> (setImagem(imageView, R.drawable.dado_4))
            5-> (setImagem(imageView, R.drawable.dado_5))
            else-> (setImagem(imageView, R.drawable.dado_6))
        }
    }

    private fun setImagem(imageView: ImageView, idImagem: Int){
        imageView.setImageDrawable(ContextCompat.getDrawable(this, idImagem))
    }

    fun gerarNumero() : Int{
        return Random().nextInt(5) + 1
    }
}
