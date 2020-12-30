package com.example.apprizka.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.apprizka.R
import com.example.apprizka.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private fun init(){
        binding.bottomNav.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.ic_home -> navigate(R.id.homeFragment)
                R.id.ic_news -> navigate(R.id.newsFragment)
                R.id.ic_favorite -> navigate(R.id.favoriteFragment)
                R.id.ic_profile -> navigate(R.id.profileFragment)
                else -> false
            }
        }
    }

    private fun navigate(id: Int): Boolean {
        findNavController(R.id.navMost).navigate(id)
        return true
    }
}