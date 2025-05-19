package com.enesturkoglu.pawtrack.data

import android.content.Context
import androidx.room.Room

object PetDatabaseInstance {

    @Volatile
    private var INSTANCE: PetDatabase? = null

    fun getDatabase(context: Context): PetDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                PetDatabase::class.java,
                "pet_database"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}