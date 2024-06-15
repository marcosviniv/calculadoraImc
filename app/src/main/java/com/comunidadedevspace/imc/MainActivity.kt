package com.comunidadedevspace.imc

import android.content.Intent
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

            if (pesoStr == "") {
                //Mostrar mensagem para usuário
                Snackbar.make(
                    edtPeso,
                    "Por favor, digite um número válido para peso. Ex: 70.5",
                    Snackbar.LENGTH_LONG
                ).show()
            } else if (alturaStr == "") {
                Snackbar.make(
                    edtAltura,
                    "Por favor, digite um número válido para altura. Ex: 1.70",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()


                val alturaQ2 = altura * altura
                val resultado = peso / alturaQ2

                // Navegar para próxima tela
                // Criar o Layout da próxima tela
                // Passar dados (resultado) para próxima tela

                // Para chamar a próxima tela, precisamos usar o Intent
                // Intent é uma classe do próprio android e serve para declarar a inteção de fazer algo no sistema operacional android
                // Intent explicita e Intent Implicita

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("KEY_RESULT_IMC", resultado)
                startActivity(intent)

                // Cores
                //EditText Background + Icone
                // Gradiente + icone + titulo + descricrição
            }
        }

    }
}