package com.corneliudascalu.breadcalculator

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.corneliudascalu.breadcalculator.databinding.FragmentRecipeBinding

class RecipeFragment : Fragment(R.layout.fragment_recipe) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentRecipeBinding.bind(view)
        arguments?.get(KEY_DOUGH_CHOICES)?.also {
            val doughChoices = it as DoughChoices
            val fermentedFlour = doughChoices.flour * doughChoices.fermentedFlourPercent
            val starter: Ingredient.Starter = Ingredient.Starter(
                Ingredient.Flour(fermentedFlour.toInt()),
                Ingredient.Water(fermentedFlour.toInt())
            )
            val flour = Ingredient.Flour(doughChoices.flour - starter.flour.quantity)
            val water =
                Ingredient.Water((doughChoices.flour * doughChoices.waterPercent - starter.water.quantity).toInt())
            val salt = Ingredient.Salt((doughChoices.flour * 0.02).toInt())
            binding.recipeText.text =
                "Add ${water.quantity} grams water.\n" +
                        "Add ${salt.quantity} grams salt.\n" +
                        "Add ${starter.quantity} grams starter and mix well.\n" +
                        "Add ${flour.quantity} grams flour and incorporate."
        }
    }
}