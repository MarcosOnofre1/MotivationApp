package com.example.motivationapp.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.motivationapp.infra.MotivationConstants
import com.example.motivationapp.R
import com.example.motivationapp.data.Mock
import com.example.motivationapp.infra.SecurityPreferences
import com.example.motivationapp.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var filter = MotivationConstants.FILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Esconder a barra de nav
        supportActionBar?.hide()

        // Nome do usuario na tela main
        handleUserName()

        // Evento de tint menu
        handleFilter(R.id.image_All)

        // Frases no menu
        refreshPhrase()

        // Evento de clicks
        handleEventClicks()
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_new_phrase) {
            refreshPhrase()

        } else if (view.id in listOf(R.id.image_All, R.id.image_Happy, R.id.image_Sunny)) {
            handleFilter(view.id)
        }
    }

    private fun handleEventClicks() {
        binding.btnNewPhrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)

    }

    private fun refreshPhrase() {
        binding.textPhraseMain.text = Mock().getPhrase(filter, Locale.getDefault().language)
    }

    private fun handleFilter(id: Int) {

        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_All -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                filter = MotivationConstants.FILTER.ALL

            }

            R.id.image_Happy -> {
                binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
                filter = MotivationConstants.FILTER.HAPPY

            }

            R.id.image_Sunny -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                filter = MotivationConstants.FILTER.SUNNY

            }
        }
    }

    private fun handleUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)

        // Mudamos o "ola" para uma variavel para assim conseguir mudar junto com o idioma selecioinado pelo sistema.
        val hello = getString(R.string.hello)
        binding.textUserNameHome.text = "$hello, $name"
    }
}