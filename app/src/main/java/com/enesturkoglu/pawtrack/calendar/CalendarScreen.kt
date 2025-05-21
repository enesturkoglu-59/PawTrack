package com.enesturkoglu.pawtrack.calendar

import android.app.Application
import android.widget.CalendarView
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.enesturkoglu.pawtrack.data.PetDatabase
import com.enesturkoglu.pawtrack.data.model.VaccineEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale


@Composable
fun CalendarScreen(
    petId: Int // Bu ekranı çağırırken seçili pet'in ID'sini gönder
) {
    RequestNotificationPermission()
    val context = LocalContext.current
    val viewModel = remember { CalendarViewModel(context.applicationContext as Application) }

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
                viewModel.saveVaccineInfo(petId) { name, date ->
                    Toast.makeText(context, "Aşı eklendi: $name - $date", Toast.LENGTH_SHORT).show()
                }
            },
            enabled = selectedDate.isNotEmpty() && vaccineText.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Aşıyı Kaydet")
        }
    }
}


