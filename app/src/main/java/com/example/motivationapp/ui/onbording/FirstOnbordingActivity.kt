package com.example.motivationapp.ui.onbording

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.motivationapp.R
import com.example.motivationapp.databinding.ActivityFirstOnbordingBinding
import com.example.motivationapp.infra.MotivationConstants
import com.example.motivationapp.infra.SecurityPreferences
import com.example.motivationapp.ui.MainActivity

class FirstOnbordingActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityFirstOnbordingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_onbording)
        binding = ActivityFirstOnbordingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        verifyUserName()

        binding.btnNext.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if(v.id == R.id.btn_next) {
            startActivity(Intent(this, SecondOnbordingActivity::class.java))
            finish()
        }
    }
    private fun verifyUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        if (name != ""){
            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }
    }
}