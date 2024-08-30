package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var inputExpresion: EditText
    private lateinit var btnCalcular: Button
    private lateinit var txtResultado: TextView
    private val calculadora = Calculadora()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputExpresion = findViewById(R.id.inputExpresion)
        btnCalcular = findViewById(R.id.btnCalcular)
        txtResultado = findViewById(R.id.txtResultado)

        btnCalcular.setOnClickListener {
            val expresion = inputExpresion.text.toString()
            val resultado = calculadora.calcular(expresion)
            txtResultado.text = "Resultado: $resultado"
        }
    }
}