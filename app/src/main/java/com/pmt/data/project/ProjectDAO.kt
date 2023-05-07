package com.pmt.data.project

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

import kotlinx.coroutines.flow.Flow

@Dao
interface ProjectDao {
    @Query("SELECT * from projects ORDER BY Name ASC")
    fun getAllProjects(): Flow<List<Project>>

    @Query("SELECT * from projects WHERE id = :id")
    fun getProject(id: Int): Flow<Project>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(project: Project)

    @Update
    suspend fun update(project: Project)

    @Delete
    suspend fun delete(project: Project)
}