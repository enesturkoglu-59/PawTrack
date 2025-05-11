package com.enesturkoglu.pawtrack.homescreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun BottomNavBarSimple(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    NavigationBar(containerColor = Color.Black) {
        NavigationBarItem(
            selected = selectedIndex == 0,
            onClick = { onItemSelected(0) },
            icon = {
                Icon(Icons.Default.Favorite, contentDescription = "Pet")
            },
            label = { Text("Pet") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFFFF7043),
                selectedTextColor = Color(0xFFFF7043),
                unselectedIconColor = Color.LightGray,
                unselectedTextColor = Color.LightGray
            )
        )

        NavigationBarItem(
            selected = selectedIndex == 1,
            onClick = { onItemSelected(1) },
            icon = {
                Icon(Icons.Default.Edit, contentDescription = "Diary")
            },
            label = { Text("Diary") }
        )
        NavigationBarItem(
            selected = selectedIndex == 2,
            onClick = { onItemSelected(2) },
            icon = {
                Icon(Icons.Default.Add, contentDescription = "Expense")
            },
            label = { Text("Expense") }
        )
        NavigationBarItem(
            selected = selectedIndex == 3,
            onClick = { onItemSelected(3) },
            icon = {
                Icon(Icons.Default.DateRange, contentDescription = "Calendar")
            },
            label = { Text("Calendar") }
        )
    }
}
