package com.corneliudascalu.breadcalculator

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

const val KEY_DOUGH_CHOICES = "doughChoices"

sealed class Ingredient(val quantity: Int) {
    class Flour(quantity: Int) : Ingredient(quantity)
    class Water(quantity: Int) : Ingredient(quantity)
    class Salt(quantity: Int) : Ingredient(quantity)
    class Starter(val flour: Flour, val water: Water) : Ingredient(flour.quantity + water.quantity)
}

@Parcelize
data class DoughChoices(
    val flour: Int,
    val waterPercent: Float,
    val fermentedFlourPercent: Float
) : Parcelable