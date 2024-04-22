package com.example.motivationapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.motivationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Esconder a barra de nav
        supportActionBar?.hide()

        // Nome do usuario na tela main
        handleUserName()

        // Evento de clicks
        binding.btnNewPhrase.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_new_phrase) {
        }
    }

    private fun handleUserName() {
        val name = SecurityPreferences(this).getString("USER_NAME")
        binding.textUserNameHome.text = "Olá, $name"
    }
}