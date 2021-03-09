package com.corneliudascalu.breadcalculator

import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit

object Navigator {
    fun navigateToCalculator(fragmentManager: FragmentManager) {
        fragmentManager.commit {
            replace(R.id.container, CalculatorFragment())
            addToBackStack(null)
        }
    }

    fun navigateToRecipe(fragmentManager: FragmentManager, doughChoices: DoughChoices) {
        fragmentManager.commit {
            val recipeFragment = RecipeFragment()
            recipeFragment.arguments = bundleOf(KEY_DOUGH_CHOICES to doughChoices)
            replace(R.id.container, recipeFragment)
            addToBackStack(null)
        }
    }
}