package com.enesturkoglu.pawtrack.data.local


import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "pets")
data class PetEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val species: String, // örnek: "Kedi", "Köpek"
    val birthDate: String? = null, // isteğe bağlı
    val notes: String? = null // açıklama alanı gibi
)