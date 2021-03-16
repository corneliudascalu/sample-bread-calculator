package com.corneliudascalu.breadcalculator

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.corneliudascalu.breadcalculator.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentLoginBinding.bind(view)
        binding.loginButton.setOnClickListener {
            if (binding.email.text?.toString()?.equals("corneliu.dascalu@gmail.com") == true
                && binding.password.text?.toString()?.equals("Test1234") == true
            ) {
                User.storeToken(requireContext(), "asdfghjkl")
                navigateToCalculator()
            } else {
                binding.passwordLayout.error = "Invalid username or password"
            }
        }
    }

    private fun navigateToCalculator() {
        Navigator.navigateToFlutterCalculator(parentFragmentManager)
    }
}