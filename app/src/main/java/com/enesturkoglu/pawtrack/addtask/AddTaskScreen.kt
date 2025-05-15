package com.enesturkoglu.pawtrack.addtask

import android.app.TimePickerDialog
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun AddTaskScreen() {
    var selectedTaskType by remember { mutableStateOf("Yem koyma") }
    var selectedTime by remember { mutableStateOf("Seçilmedi") }
    var reminderOffset by remember { mutableStateOf(15f) }

    val taskOptions = listOf("Yem koyma", "Su koyma", "Kum değiştirme")

    var showTimePicker by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        // Görev türü seçimi
        Text(text = "Görev Türü")
        DropdownMenuTaskSelector(
            options = taskOptions,
            selectedOption = selectedTaskType,
            onOptionSelected = { selectedTaskType = it }
        )

        // Saat seçici
        Text(text = "Görev Saati")
        Button(onClick = { showTimePicker = true }) {
            Text(text = selectedTime)
        }

        // Hatırlatma süresi
        Text(text = "Kaç dakika önce hatırlatılsın?")
        Slider(
            value = reminderOffset,
            onValueChange = { reminderOffset = it },
            valueRange = 0f..60f,
            steps = 5
        )
        Text(text = "${reminderOffset.roundToInt()} dakika önce")

        // Kaydet butonu
        Button(
            onClick = {
                // Şimdilik sadece yazdır
                println("Görev: $selectedTaskType - $selectedTime - ${reminderOffset.roundToInt()}dk önce")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Görevi Kaydet")
        }
    }

    if (showTimePicker) {
        TimePickerDialog(
            onTimeSelected = {
                selectedTime = it
                showTimePicker = false
            },
            onDismiss = { showTimePicker = false }
        )
    }
}