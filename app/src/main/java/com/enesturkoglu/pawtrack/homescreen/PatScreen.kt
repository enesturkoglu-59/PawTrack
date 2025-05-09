package com.enesturkoglu.pawtrack.homescreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetTopAppBar() {



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

}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun PetTopAppBarPreview() {
    PetTopAppBar()
}
