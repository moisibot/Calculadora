package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.OptIn
import androidx.media3.common.util.Log
import androidx.media3.common.util.UnstableApi
import com.example.calculadora.Analizadores.parser

class MainActivity : AppCompatActivity() {
    private lateinit var inputExpresion: EditText
    private lateinit var btnCalcular: Button
    private lateinit var txtResultado: TextView
    private val calculadora = Calculadora()

    @OptIn(UnstableApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            Log.d("MainActivity", "Iniciando onCreate")
            inputExpresion = findViewById(R.id.inputExpresion)
            btnCalcular = findViewById(R.id.btnCalcular)
            txtResultado = findViewById(R.id.txtResultado)

            btnCalcular.setOnClickListener {
                try {
                    val expresion = inputExpresion.text.toString()
                    Log.d("Calculadora", "Expresión a calcular: $expresion")
                    val resultado = calculadora.calcular(expresion)
                    Log.d("Calculadora", "Resultado obtenido: $resultado")
                    txtResultado.text = "Resultado: $resultado"
                } catch (e: Exception) {
                    Log.e("Calculadora", "Error al calcular", e)
                    val errorMessage = e.message ?: "Error desconocido"
                    txtResultado.text = "Error: $errorMessage"
                    Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
                }
            }
        } catch (e: Exception) {
            Log.e("MainActivity", "Error en onCreate: ${e.message}", e)
            Toast.makeText(this, "Error en onCreate: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }
}