package com.corneliudascalu.breadcalculator

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit

object Navigator {
    fun navigateToCalculator(fragmentManager: FragmentManager) {
        fragmentManager.commit {
            replace(R.id.container, CalculatorFragment())
            addToBackStack(null)
        }
    }

    fun navigateToRecipe() {
        TODO("Not yet implemented")
    }
}