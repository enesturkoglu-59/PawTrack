package com.enesturkoglu.pawtrack.addpet

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog

import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
data class Profile(val name: String)

@Serializable
object FriendsList

// Define the ProfileScreen composable.
@Composable
fun ProfileScreen(
    profile: String,
    onNavigateToFriendsList: () -> Unit
) {
    Column {
        Text("Profile for ${profile}")
        Button(onClick = { onNavigateToFriendsList() }) {
            Text("Go to Friends List")
        }
    }

}

// Define the FriendsListScreen composable.
@Composable
fun FriendsListScreen(onNavigateToProfile: () -> Unit) {

    Column {
        Text("Friends List")
        Button(onClick = { onNavigateToProfile() }) {
            Text("Go to Profile")
        }
    }

}

// Define the MyApp composable, including the `NavController` and `NavHost`.
@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Profile(name = "John Smith")) {
        composable<Profile> { backStackEntry ->
            val profile: Profile = backStackEntry.toRoute()
            val pro = Profile("sa")
            ProfileScreen(
                profile = pro.name,
                onNavigateToFriendsList = {
                    navController.navigate(route = FriendsList)
                }
            )
        }
        composable<FriendsList> {
            FriendsListScreen(
                onNavigateToProfile = {
                    navController.navigate(
                        route = Profile(name = "Aisha Devi")
                    )
                }
            )
        }
    }
}