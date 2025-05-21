package com.enesturkoglu.pawtrack.calendar

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enesturkoglu.pawtrack.calendar.util.scheduleNotification
import com.enesturkoglu.pawtrack.data.PetDatabase
import com.enesturkoglu.pawtrack.data.PetDatabaseInstance
import com.enesturkoglu.pawtrack.data.model.VaccineEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale

class CalendarViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val _selectedDate = MutableStateFlow("")
    val selectedDate = _selectedDate.asStateFlow()

    private val _vaccineText = MutableStateFlow("")
    val vaccineText = _vaccineText.asStateFlow()

    private val vaccineDao = PetDatabaseInstance.getDatabase(application).vaccineDao()

    fun onDateSelected(date: String) {
        _selectedDate.value = date
    }

    fun onVaccineTextChanged(text: String) {
        _vaccineText.value = text
    }

    fun saveVaccineInfo(petId: Int, onSaved: (String, String) -> Unit) {
        val date = _selectedDate.value
        val name = _vaccineText.value

        if (date.isNotEmpty() && name.isNotBlank()) {
            viewModelScope.launch {
                val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val dateObj = formatter.parse(date) ?: return@launch
                val millis = dateObj.time

                val vaccine = VaccineEntity(
                    petId = petId,
                    name = name,
                    date = date,
                    timestamp = millis
                )

                vaccineDao.insertVaccine(vaccine)
                scheduleNotification(getApplication(), vaccine) // Bildirim kur
                onSaved(name, date)

                // Temizleme
                _vaccineText.value = ""
                _selectedDate.value = ""
            }
        }
    }
}
