package com.example.motivationapp.infra

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {

    private val security: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, str: String) {
        security.edit().putString(key, str).apply()
    }

    fun getString(key: String): String {
        // Expressao Elvis, se acaso um for nulo, o outro é usado e vice versa. Lembrando que nao é operador ternario, pois nao existe
        return security.getString(key, "") ?: ""
    }
}
