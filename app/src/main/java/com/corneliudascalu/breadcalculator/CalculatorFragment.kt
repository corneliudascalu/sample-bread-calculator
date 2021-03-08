package com.corneliudascalu.breadcalculator

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.corneliudascalu.breadcalculator.databinding.FragmentCalculatorBinding
import com.google.android.material.slider.Slider

class CalculatorFragment : Fragment(R.layout.fragment_calculator) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentCalculatorBinding.bind(view)
        binding.waterSlider.addOnChangeListener { slider, value, fromUser ->
            binding.hydrationPercentage.text = "${value.toInt()}%"
        }
    }
}