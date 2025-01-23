package com.example.testapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.testapp.ui.components.FitnessDataCard

@Composable
fun DashboardScreen(fitnessViewModel: FitnessViewModel = viewModel()) {
    // Collect state from ViewModel
    val steps by fitnessViewModel.steps.collectAsState()
    val calories by fitnessViewModel.calories.collectAsState()
    val distance by fitnessViewModel.distance.collectAsState()

    // UI
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Dashboard",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Display fitness data
        FitnessDataCard(label = "Steps", value = "$steps")
        FitnessDataCard(label = "Calories", value = "$calories kcal")
        FitnessDataCard(label = "Distance", value = "$distance km")

        Spacer(modifier = Modifier.height(16.dp))

        // Buttons to update fitness data
        Button(onClick = { fitnessViewModel.addSteps(500) }) {
            Text("Add Steps")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { fitnessViewModel.addCalories(50) }) {
            Text("Add Calories")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { fitnessViewModel.addDistance(0.5f) }) {
            Text("Add Distance")
        }
    }
}