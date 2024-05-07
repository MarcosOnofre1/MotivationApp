package com.example.motivationapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.motivationapp.infra.MotivationConstants
import com.example.motivationapp.R
import com.example.motivationapp.infra.SecurityPreferences
import com.example.motivationapp.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnSaveName.setOnClickListener(this)

        // verifica se o nome ja ta salvo, entao vai direto para mainActivity
        verifyUserName()

    }


    override fun onClick(v: View) {
        if (v.id == R.id.btn_save_name) {
            handleSave()
        }
    }

    private fun verifyUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        if (name != "") {
            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }

    }

    private fun handleSave() {

        // obtem o nome
        val name = binding.edtName.text.toString()

        // verifica se o usuario preencheu o nome
        if (name != "") {
            //salvando os dados do usuario e redireciona para as frases
            SecurityPreferences(this).storeString(MotivationConstants.KEY.USER_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))

            finish()

        } else {
            Toast.makeText(this, getString(R.string.provide_your_name), Toast.LENGTH_SHORT).show()

        }
    }
}