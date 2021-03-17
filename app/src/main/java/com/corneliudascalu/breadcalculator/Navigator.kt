package com.corneliudascalu.breadcalculator

import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import io.flutter.embedding.android.FlutterFragment

object Navigator {
    fun navigateToCalculator(fragmentManager: FragmentManager) {
        fragmentManager.commit {
            replace(R.id.container, CalculatorFragment())
        }
    }

    fun navigateToFlutterCalculator(fragmentManager: FragmentManager) {
        fragmentManager.commit {
            val flutterFragment =
                FlutterFragment.withCachedEngine(FLUTTER_ENGINE_ID).build<FlutterFragment>()
            replace(R.id.container, flutterFragment)
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