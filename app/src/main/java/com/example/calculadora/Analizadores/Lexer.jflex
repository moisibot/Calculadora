package com.example.calculadora.Analizadores;

import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.*;
%%
%class AnalizadorLexico
%public
%unicode
%cup
%line
%column

%{
    private Symbol symbol(int type) {
        return new Symbol(type, yyline + 1, yycolumn + 1);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline + 1, yycolumn + 1, value);
    }

    private ArrayList<String> errores = new ArrayList<>();
%}

%init{
    yyline = 1;
    yycolumn = 1;
%init}

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]
Numero         = ([0-9]+(\.[0-9]+)?) | (\.[0-9]+)

%%

<YYINITIAL> {
    "+"            { return symbol(sym.SUMA); }
    "-"            { return symbol(sym.RESTA); }
    "*"            { return symbol(sym.MULTIPLICACION); }
    "/"            { return symbol(sym.DIVISION); }
    "("            { return symbol(sym.PARENTESIS_ABIERTO); }
    ")"            { return symbol(sym.PARENTESIS_CERRADO); }

    {Numero}       { return symbol(sym.NUMERO, Double.parseDouble(yytext())); }
    {WhiteSpace}   { /* ignorar */ }
}

[^] {
    String errorMsg = "Error léxico: Carácter inválido <" + yytext() + "> en línea " + (yyline+1) + ", columna " + (yycolumn+1);
    errores.add(errorMsg);
    System.out.println(errorMsg);
}