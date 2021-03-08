package com.corneliudascalu.breadcalculator

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.corneliudascalu.breadcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val prefs = getPreferences(MODE_PRIVATE)
        val token = prefs.getString("token", "") ?: ""
        if (token.isEmpty()) {
            supportFragmentManager.commit {
                replace(R.id.container, LoginFragment())
                addToBackStack(null)
            }
        } else {
            supportFragmentManager.commit {
                replace(R.id.container, CalculatorFragment())
                addToBackStack(null)
            }
        }
    }
}