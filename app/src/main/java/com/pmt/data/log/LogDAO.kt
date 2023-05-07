package com.pmt.data.log

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

import kotlinx.coroutines.flow.Flow

@Dao
interface LogDao {
    @Query("SELECT * from logs ORDER BY Name ASC")
    fun getAllLogs(): Flow<List<Log>>

    @Query("SELECT * from logs WHERE project_id = :projectId")
    fun getAllLogsByProjectId(projectId: Int): Flow<List<Log>>

    @Query("SELECT * from logs WHERE id = :id")
    fun getLog(id: Int): Flow<Log>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(log: Log)

    @Update
    suspend fun update(log: Log)

    @Delete
    suspend fun delete(log: Log)
}