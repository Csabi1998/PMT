package com.pmt.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pmt.data.project.Project
import com.pmt.data.project.ProjectDao
import com.pmt.data.log.Log
import com.pmt.data.log.LogDao

@Database(entities = [Project::class, Log::class], version = 1, exportSchema = false)
abstract class PmtDatabase : RoomDatabase() {
    abstract fun projectDao(): ProjectDao
    abstract fun logDao(): LogDao
}