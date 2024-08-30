package com.example.calculadora

import com.example.calculadora.Analizadores.AnalizadorLexico
import com.example.calculadora.Analizadores.parser
import java_cup.runtime.Symbol
import java.io.StringReader

class Calculadora {
    fun calcular(expresion: String): Double {
        val reader = StringReader(expresion)
        val lexer = AnalizadorLexico(reader)
        val parser = parser(lexer)

        return try {
            val result = parser.parse()
            result.value as Double
        } catch (e: Exception) {
            println("Error al calcular la expresión: ${e.message}")
            throw Exception("Error en el cálculo: ${e.message}")
        }
    }
}