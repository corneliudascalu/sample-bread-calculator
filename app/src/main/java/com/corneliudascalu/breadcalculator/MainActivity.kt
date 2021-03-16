package com.corneliudascalu.breadcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.corneliudascalu.breadcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val token = User.getToken(this)
        if (token.isEmpty()) {
            supportFragmentManager.commit {
                replace(R.id.container, LoginFragment())
            }
        } else {
            supportFragmentManager.commit {
                replace(R.id.container, CalculatorFragment())
                addToBackStack(null)
            }
        }
    }
}