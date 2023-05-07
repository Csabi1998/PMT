package com.pmt.data.log

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "logs")
data class Log (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "working_hour") var workingHour: Double,
    @ColumnInfo(name = "creator_name") var creatorName: String,
    @ColumnInfo(name = "project_id") var projectId: String
)