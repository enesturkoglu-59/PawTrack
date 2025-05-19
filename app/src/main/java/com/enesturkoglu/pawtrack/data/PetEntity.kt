package com.enesturkoglu.pawtrack.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pets")
data class PetEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val age: String,
    val weight: String
)