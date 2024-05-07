package com.example.motivationapp.ui.onbording

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.motivationapp.R
import com.example.motivationapp.databinding.ActivitySecondOnbordingBinding
import com.example.motivationapp.databinding.ActivityThirdOnbordingBinding
import com.example.motivationapp.ui.MainActivity
import com.example.motivationapp.ui.UserActivity

class ThirdOnbordingActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityThirdOnbordingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdOnbordingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnNextFinal.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_next_final){
            startActivity(Intent(this, UserActivity::class.java))
            finish()
        }
    }
}