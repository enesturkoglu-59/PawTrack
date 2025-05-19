package com.enesturkoglu.pawtrack.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PetDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPet(pet: PetEntity)

    @Delete
    suspend fun deletePet(pet: PetEntity)

    @Query("SELECT * FROM pets ORDER BY id DESC")
    fun getAllPets(): Flow<List<PetEntity>>
}