package com.example.calculadora

import com.example.calculadora.Analizadores.AnalizadorLexico
import com.example.calculadora.Analizadores.parser
import java.io.StringReader

class Calculadora {
    fun calcular(expresion: String): Double {
        val reader = StringReader(expresion)
        val lexer = AnalizadorLexico(reader)
        val parser = parser(lexer)

        return try {
            parser.parse().value as Double
        } catch (e: Exception) {
            println("Error al calcular la expresión: ${e.message}")
            Double.NaN
        }
    }
}