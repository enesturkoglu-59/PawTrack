package com.enesturkoglu.pawtrack.addpet

import android.app.Application
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.enesturkoglu.pawtrack.data.PetDatabaseInstance
import com.enesturkoglu.pawtrack.data.model.PetEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddPetViewModel(application: Application) : AndroidViewModel(application) {

    var petName by mutableStateOf("")
    var petAge by mutableStateOf("")
    var petKilo by mutableStateOf("")

    private val dao = PetDatabaseInstance.getDatabase(application).petDao()

    fun insertPet(onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.insertPet(
                PetEntity(
                    name = petName,
                    age = petAge,
                    weight = petKilo
                )
            )

            viewModelScope.launch(Dispatchers.Main) {
                Toast.makeText(getApplication(), "Başarıyla kaydedildi", Toast.LENGTH_SHORT).show()
                petName = ""
                petAge = ""
                petKilo = ""
                onSuccess()
            }
        }
    }
}
