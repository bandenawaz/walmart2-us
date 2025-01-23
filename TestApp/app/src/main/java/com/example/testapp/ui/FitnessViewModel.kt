package com.example.testapp.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FitnessViewModel : ViewModel() {
    // StateFlow for fitness data
    private val _steps = MutableStateFlow(5000)
    val steps: StateFlow<Int> = _steps

    private val _calories = MutableStateFlow(200)
    val calories: StateFlow<Int> = _calories

    private val _distance = MutableStateFlow(3.5f)
    val distance: StateFlow<Float> = _distance

    // Update functions
    fun addSteps(amount: Int) {
        _steps.value += amount
    }

    fun addCalories(amount: Int) {
        _calories.value += amount
    }

    fun addDistance(amount: Float) {
        _distance.value += amount
    }
}