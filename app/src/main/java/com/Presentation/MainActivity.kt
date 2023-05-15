package com.Presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.velmurugan.mvvmretrofitrecyclerviewkotlin.R
import com.velmurugan.mvvmretrofitrecyclerviewkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
            supportFragmentManager.beginTransaction().replace(R.id.homeFragment, MovieFragment.newInstance()).commit()
    }
}