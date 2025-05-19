package com.enesturkoglu.pawtrack.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.enesturkoglu.pawtrack.addpet.AddPetScreen
import com.enesturkoglu.pawtrack.addtask.AddTaskScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AddPet
    ) {
        composable<Task> {
            AddTaskScreen()
        }
        composable<AddPet> {
            AddPetScreen(onPetAdded = { navController.popBackStack() })
        }
        composable<Diary> {
            Text("Diary Screen")
        }
        composable<Expense> {
            Text("Expense Screen")
        }
        composable<Calendar> {
            Text("Calendar Screen")
        }
    }
}