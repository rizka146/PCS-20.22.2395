package com.apprizka.apprizka.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.apprizka.apprizka.R
import com.apprizka.apprizka.data.model.AuthUser
import com.apprizka.apprizka.databinding.ActivityAuthBinding
import com.apprizka.apprizka.ui.home.MainActivity

class AuthActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_auth)
//        setContentView(R.layout.activity_auth)
    }

    fun onSuccess(user:AuthUser?){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}