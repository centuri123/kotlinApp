package com.app.imc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners(){
        altura?.doAfterTextChanged { text ->
            //Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
         }

        peso?.doOnTextChanged { text, _, _, _ ->
            //titulo.text = text
         }

        calc_btn.setOnClickListener {
            calcularIMC(peso.text.toString(), altura.text.toString())
        }
    }

    private fun calcularIMC(peso : String, altura : String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        val imc : Float

        if (peso != null && altura != null){
            imc = peso / (altura * altura)
            titulo.text = "IMC: %.${2}f".format(imc)
        }
    }
}