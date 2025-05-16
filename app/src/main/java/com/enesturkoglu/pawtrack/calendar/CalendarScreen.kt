package com.enesturkoglu.pawtrack.calendar

import android.widget.CalendarView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun CalendarScreen() {
    var selectedDate by remember { mutableStateOf("") }
    var vaccineText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Aşı Takvimi", style = MaterialTheme.typography.headlineSmall)

        // Native CalendarView
        AndroidView(
            factory = { context ->
                CalendarView(context).apply {
                    setOnDateChangeListener { _, year, month, dayOfMonth ->
                        val formatted = "%02d/%02d/%d".format(dayOfMonth, month + 1, year)
                        selectedDate = formatted
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        // Seçilen tarihi göster
        if (selectedDate.isNotEmpty()) {
            Text(text = "Seçilen Tarih: $selectedDate")
        }

        // Aşı adı girişi
        OutlinedTextField(
            value = vaccineText,
            onValueChange = { vaccineText = it },
            label = { Text("Aşı Adı") },
            modifier = Modifier.fillMaxWidth()
        )

        // Sahte kayıt butonu
        Button(
            onClick = {
                // Şimdilik konsola yaz
                println("Aşı eklendi: $vaccineText - $selectedDate")
            },
            enabled = selectedDate.isNotEmpty() && vaccineText.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Aşıyı Kaydet")
        }
    }
}

@Preview
@Composable
fun tests(){
    CalendarScreen()
}