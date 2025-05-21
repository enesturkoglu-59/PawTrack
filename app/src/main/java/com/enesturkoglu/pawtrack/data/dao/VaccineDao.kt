package com.enesturkoglu.pawtrack.data.dao

import androidx.room.*
import com.enesturkoglu.pawtrack.data.model.VaccineEntity


@Dao
interface VaccineDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVaccine(vaccine: VaccineEntity)

    @Query("SELECT * FROM vaccine_schedule WHERE timestamp >= :now")
    suspend fun getUpcomingVaccines(now: Long): List<VaccineEntity>
}