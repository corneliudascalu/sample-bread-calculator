package com.corneliudascalu.breadcalculator

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.corneliudascalu.breadcalculator.databinding.FragmentCalculatorBinding

class CalculatorFragment : Fragment(R.layout.fragment_calculator) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentCalculatorBinding.bind(view)
        binding.waterSlider.addOnChangeListener { slider, value, fromUser ->
            binding.hydrationPercentage.text = "${value.toInt()}%"
        }
        binding.starterSlider.addOnChangeListener { slider, value, fromUser ->
            binding.starterPercentage.text = "${value.toInt()}%"
        }
        binding.submitButton.setOnClickListener {
            val breadPreferences = DoughChoices(
                binding.flourQty.text.toString().toInt(),
                (binding.waterSlider.value.toInt() / 100.0).toFloat(),
                binding.starterSlider.value / 100
            )
            Navigator.navigateToRecipe(parentFragmentManager, breadPreferences)
        }
    }
}