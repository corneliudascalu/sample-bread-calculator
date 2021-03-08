package com.corneliudascalu.breadcalculator

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.corneliudascalu.breadcalculator.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentLoginBinding.bind(view)
        binding.loginButton.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.container, CalculatorFragment())
                addToBackStack(null)
            }
        }
    }
}