package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recuperar os componenetes EditText
        // Criar uma váriavél e associar o componente de UI <TextInput>
        // Recuperar o botão da tela
        // Colocar ação no botão setOnClickListener
        // Recuperar o texto digitado no edt peso

        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        btnCalcular.setOnClickListener {

            val pesoStr: String = edtPeso.text.toString()
            val alturaStr: String = edtAltura.text.toString()

            if(pesoStr == "") {
                //Mostrar mensagem para usuário
                Snackbar.make(edtPeso, "Por favor, digite um número válido para peso. Ex: 70.5", Snackbar.LENGTH_LONG).show()
            } else if (alturaStr == "") {
                Snackbar.make(edtAltura,"Por favor, digite um número válido para altura. Ex: 1.70", Snackbar.LENGTH_LONG).show()
            } else {
                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()


                val alturaQ2 = altura * altura
                val resultado = peso / alturaQ2

                println("Marcos sua altura é: " + alturaStr + " e seu peso é " + pesoStr + " o resultado é " + resultado)

            }
        }

    }
}