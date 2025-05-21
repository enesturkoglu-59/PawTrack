package com.enesturkoglu.pawtrack.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.enesturkoglu.pawtrack.data.dao.PetDao
import com.enesturkoglu.pawtrack.data.dao.VaccineDao
import com.enesturkoglu.pawtrack.data.model.PetEntity
import com.enesturkoglu.pawtrack.data.model.VaccineEntity

@Database(
    entities = [PetEntity::class],[VaccineEntity::class],
    version = 2,
    exportSchema = false
)
abstract class PetDatabase : RoomDatabase() {
    abstract fun petDao(): PetDao
    abstract fun vaccineDao(): VaccineDao
}