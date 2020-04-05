package com.example.kotlinarchitechure.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kotlinarchitechure.LOG_VAL
import com.example.kotlinarchitechure.R
import com.example.kotlinarchitechure.util.DiceHelper

open class DiceViewModel(app: Application) : AndroidViewModel(app) {

    val headline = MutableLiveData<String>()
    val dice = MutableLiveData<IntArray>()
    private val context = app

    init {
        Log.i(LOG_VAL, "View model created")
        headline.value = context.getString(R.string.welcome)
        dice.value = intArrayOf(6, 6, 6, 6, 6)
    }

    fun rollDice() {
        dice.value = DiceHelper.rollDice()
        headline.value = DiceHelper.evaluateDice(context, dice.value)
    }
}