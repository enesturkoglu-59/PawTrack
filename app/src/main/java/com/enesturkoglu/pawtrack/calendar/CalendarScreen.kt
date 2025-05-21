package com.enesturkoglu.pawtrack.calendar

import android.widget.CalendarView
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun CalendarScreen(viewModel: CalendarViewModel = viewModel()) {
    val selectedDate = viewModel.selectedDate.collectAsState().value
    val vaccineText = viewModel.vaccineText.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Aşı Takvimi", style = MaterialTheme.typography.headlineSmall)

        AndroidView(
            factory = { context ->
                CalendarView(context).apply {
                    setOnDateChangeListener { _, year, month, dayOfMonth ->
                        val formatted = "%02d/%02d/%d".format(dayOfMonth, month + 1, year)
                        viewModel.onDateSelected(formatted)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        if (selectedDate.isNotEmpty()) {
            Text(text = "Seçilen Tarih: $selectedDate")
        }

        OutlinedTextField(
            value = vaccineText,
            onValueChange = { viewModel.onVaccineTextChanged(it) },
            label = { Text("Aşı Adı") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                viewModel.saveVaccineInfo { name, date ->
                    println("Aşı eklendi: $name - $date")
                }
            },
            enabled = selectedDate.isNotEmpty() && vaccineText.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Aşıyı Kaydet")
        }
    }
}



@Composable
fun tests(){
    CalendarScreen()
}