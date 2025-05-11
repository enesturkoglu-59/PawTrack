package com.enesturkoglu.pawtrack.homescreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetTopAppBar() {
    var selectedIndex by remember { mutableStateOf(0) }

Column {
    CenterAlignedTopAppBar(
        title = {
            SelectPetDropdown(
                petList = listOf("Mia", "Leo", "Pasha"),
                selectedPet = "Select Pet",
                onPetSelected = { selectedPetName -> /* işlemler */ }
            )
        },
        navigationIcon = {
            IconButton(onClick = { /* TODO: Ayarlar ekranına git */ }) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings"
                )
            }
        },
        actions = {
            IconButton(onClick = { /* TODO: Pet düzenleme ekranı */ }) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit"
                )
            }
            IconButton(onClick = { /* TODO: Daha fazla seçenek */ }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More Options"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White,
            navigationIconContentColor = Color(0xFFFF7043),
            actionIconContentColor = Color(0xFFFF7043)
        )
    )

    Scaffold(
        bottomBar = {
            BottomNavBarSimple(
                selectedIndex = selectedIndex,
                onItemSelected = { selectedIndex = it }
            )
        }
    ) { padding ->
        Box(modifier = Modifier
            .padding(padding)
            .fillMaxSize()) {

            when (selectedIndex) {
                0 -> Text("Pet Screen")
                1 -> Text("Diary Screen")
                2 -> Text("Expense Screen")
                3 -> Text("Calendar Screen")
            }
        }
    }

}
}




@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun PetTopAppBarPreview() {
    PetTopAppBar()
}
