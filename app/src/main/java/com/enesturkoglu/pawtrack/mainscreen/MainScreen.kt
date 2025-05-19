package com.enesturkoglu.pawtrack.mainscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainApp(){

    Scaffold(bottomBar = { } ) {
Column(modifier = Modifier.padding(it)) {

    Button(onClick = {}) {
        Text("test")
    }
}
    }
}
@Preview
@Composable
fun MainApptest(){
    MainApp()
}