package com.enesturkoglu.pawtrack.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vaccine_schedule")
data class VaccineEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val petId: Int,
    val name: String,
    val date: String, // "dd/MM/yyyy"
    val timestamp: Long
)