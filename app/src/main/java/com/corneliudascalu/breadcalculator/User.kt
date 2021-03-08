package com.corneliudascalu.breadcalculator

import android.content.Context

object User {
    fun storeToken(context: Context, token: String) {
        val sharedPreferences = context.getSharedPreferences("calculator", Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("token", token).apply()
    }

    fun getToken(context: Context): String {
        val sharedPreferences = context.getSharedPreferences("calculator", Context.MODE_PRIVATE)
        return sharedPreferences.getString("token", "") ?: ""
    }
}