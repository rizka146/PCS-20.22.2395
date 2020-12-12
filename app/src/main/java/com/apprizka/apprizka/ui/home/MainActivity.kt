package com.apprizka.apprizka.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.apprizka.apprizka.R
import com.apprizka.apprizka.databinding.ActivityAuthBinding
import com.apprizka.apprizka.databinding.ActivityMainBinding
import com.apprizka.apprizka.ui.auth.ApprizkaAuth
import com.apprizka.apprizka.ui.auth.AuthActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.buttonLogout.setOnClickListener {
            ApprizkaAuth.logout(this){
                startActivity(Intent(this,AuthActivity::class.java))
                finish()
            }
        }
    }
}