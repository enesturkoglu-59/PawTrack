package com.enesturkoglu.pawtrack.navigation

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.enesturkoglu.pawtrack.addpet.AddPetScreen
import com.enesturkoglu.pawtrack.addpet.AddPetViewModel
import com.enesturkoglu.pawtrack.addtask.AddTaskScreen
import com.enesturkoglu.pawtrack.calendar.CalendarScreen

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun AppNavGraph(navController: NavHostController,paddingValues: PaddingValues) {
    val context = LocalContext.current.applicationContext as Application
    val addPetViewModel = remember { AddPetViewModel(context) }

    NavHost(
        navController = navController,
        startDestination = AddPet,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable<Task> {
            AddTaskScreen()
        }
        composable<AddPet> {
            AddPetScreen(onPetAdded = { navController.popBackStack() }, viewModel =addPetViewModel  )
        }

        composable<Calendar> {
            CalendarScreen()
        }
    }
}