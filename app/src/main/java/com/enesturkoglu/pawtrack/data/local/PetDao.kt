package com.enesturkoglu.pawtrack.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PetDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPet(pet: PetEntity)

    @Delete
    suspend fun deletePet(pet: PetEntity)

    @Query("SELECT * FROM pets ORDER BY id ASC")
    fun getAllPets(): Flow<List<PetEntity>>

    @Query("SELECT * FROM pets WHERE id = :petId")
    suspend fun getPetById(petId: Int): PetEntity?
}
