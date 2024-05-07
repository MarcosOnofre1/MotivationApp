package com.example.motivationapp.infra

class MotivationConstants private constructor(){

    // criado essa constant p/ evitar erros de digitação do codigo e ter uma melhor visibilidade do codigo.
    // usamos o privete constructor para ninguem instaciar essa classe.
    object KEY{
        const val USER_NAME = "USER_NAME"
    }

    object FILTER {
        const val ALL = 1
        const val HAPPY = 2
        const val SUNNY = 3
    }

    object LANGUAGE {
        const val PORTUGUESE = "pt"
        const val ENGLISH = "en"

    }
}