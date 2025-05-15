package com.enesturkoglu.pawtrack.addpet

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp

@Composable
fun AddPetScreen(){
    var petName = remember { mutableStateOf("") }
    Box(modifier =
    Modifier.fillMaxSize()
        .background(Color.Black)){
        Column( horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(15.dp))
            Box(modifier =
            Modifier.size(120.dp)
                .clip(CircleShape)
                .background(Color.White)
                ){

            }
            Box(
                modifier = Modifier

                    .offset(x = 45.dp, y = -40.dp)
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFFF7043))
                    .clickable {
                        // Fotoğraf ekleme işlemi burada olacak
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Photo",
                    tint = Color.White,
                    modifier = Modifier.size(15.dp)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            TextField(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                value = petName.value,
                onValueChange = { petName.value = it },
                label = { Text("Pet Name") }
            )
            Spacer(modifier = Modifier.height(15.dp))
            TextField(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                value = petName.value,
                onValueChange = { petName.value = it },
                label = { Text("Pet Name") }
            )
            Spacer(modifier = Modifier.height(15.dp))
            TextField(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                value = petName.value,
                onValueChange = { petName.value = it },
                label = { Text("Pet Name") }
            )
            Spacer(modifier = Modifier.height(15.dp))
            Button(modifier = Modifier.size(width = 200.dp, height = 50.dp), onClick = {},   colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF5722), // arka plan rengi (yeşil)
                contentColor = Color.White          // yazı/ikon rengi
            )) {
                Text("Save")
            }
        }
    }
}


@Preview
@Composable
fun TestAddpetScreen(){
    AddPetScreen()
}