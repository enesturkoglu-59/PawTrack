package com.enesturkoglu.pawtrack.calendar

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CalendarViewModel : ViewModel() {

    private val _selectedDate = MutableStateFlow("")
    val selectedDate = _selectedDate.asStateFlow()

    private val _vaccineText = MutableStateFlow("")
    val vaccineText = _vaccineText.asStateFlow()

    fun onDateSelected(date: String) {
        _selectedDate.value = date
    }

    fun onVaccineTextChanged(text: String) {
        _vaccineText.value = text
    }

    fun saveVaccineInfo(onSaved: (String, String) -> Unit) {
        if (_selectedDate.value.isNotEmpty() && _vaccineText.value.isNotBlank()) {
            onSaved(_vaccineText.value, _selectedDate.value)
            _vaccineText.value = ""
            _selectedDate.value = ""
        }
    }
}
