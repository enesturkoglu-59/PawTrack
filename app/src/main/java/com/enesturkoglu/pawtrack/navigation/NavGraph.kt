package com.enesturkoglu.pawtrack.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.enesturkoglu.pawtrack.addpet.AddPetScreen
import com.enesturkoglu.pawtrack.addtask.AddTaskScreen
import com.enesturkoglu.pawtrack.calendar.CalendarScreen

@Composable
fun AppNavGraph(navController: NavHostController,paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = AddPet,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable<Task> {
            AddTaskScreen()
        }
        composable<AddPet> {
            AddPetScreen(onPetAdded = { navController.popBackStack() })
        }

        composable<Calendar> {
            CalendarScreen()
        }
    }
}