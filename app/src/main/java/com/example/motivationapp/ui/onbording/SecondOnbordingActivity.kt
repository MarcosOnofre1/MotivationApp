package com.example.motivationapp.ui.onbording

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.motivationapp.R
import com.example.motivationapp.databinding.ActivityFirstOnbordingBinding
import com.example.motivationapp.databinding.ActivitySecondOnbordingBinding

class SecondOnbordingActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivitySecondOnbordingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondOnbordingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnNextSecond.setOnClickListener(this)

    }

    override fun onClick(vi: View) {
        if(vi.id == R.id.btn_next_second){
            startActivity(Intent(this, ThirdOnbordingActivity::class.java))
            finish()
        }
    }
}