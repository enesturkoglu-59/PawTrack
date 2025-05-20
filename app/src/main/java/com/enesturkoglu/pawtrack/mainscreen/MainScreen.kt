package com.enesturkoglu.pawtrack.mainscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.enesturkoglu.pawtrack.navigation.AddPet
import com.enesturkoglu.pawtrack.navigation.AppNavGraph
import com.enesturkoglu.pawtrack.navigation.Calendar
import com.enesturkoglu.pawtrack.navigation.Screen
import com.enesturkoglu.pawtrack.navigation.Task

@Composable
fun MainApp(){
    val navController = rememberNavController()
    val backStackEntry = navController.currentBackStackEntryAsState().value
    val currentRoute = try {
        backStackEntry?.toRoute<Screen>()
    } catch (e: Exception) {
        null // deserialize edilemiyorsa null
    }

    Scaffold(topBar = {  PetTopBar(
        selectedPet = "Mırmır",
        onPetClick = { /* pet dropdown aç */ },
        onSettingsClick = { /* settings ekranına git */ }
    )}, bottomBar = { NavigationBar {
        NavigationBarItem(
            selected = currentRoute==AddPet,
            onClick = { navController.navigate(AddPet) },
            icon = { Icon(Icons.Default.Home, null) },
            label = { Text("Home") },
            alwaysShowLabel = true
        )
        NavigationBarItem(
            selected = currentRoute==Task,
            onClick = { navController.navigate(Task) },
            icon = { Icon(Icons.Default.Notifications, null) },
            label = { Text("Tasks") },
            alwaysShowLabel = true
        )
        NavigationBarItem(
            selected = true,
            onClick = { navController.navigate(Calendar)},
            icon = { Icon(Icons.Default.Create, null) },
            label = { Text("Plans") },
            alwaysShowLabel = true
        )

    } } ) {

        AppNavGraph(navController,it)

    }
}


@Preview
@Composable
fun MainApptest(){
    MainApp()
}