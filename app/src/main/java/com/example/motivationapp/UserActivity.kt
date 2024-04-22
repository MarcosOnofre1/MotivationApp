package com.example.motivationapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.motivationapp.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnSaveName.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_save_name) {
            handleSave()
        }
    }

    private fun handleSave() {

        // pega info
        val name = binding.edtName.text.toString()
        if (name != "") {

            //salvando nome do usuario
            SecurityPreferences(this).storeString("USER_NAME", name)

            startActivity(Intent(this, MainActivity::class.java))
            finish()

        } else {
            Toast.makeText(this, "Informe seu nome.", Toast.LENGTH_SHORT).show()

        }
    }

}