package com.pmt.data.project

import androidx.room.ColumnInfo
import androidx.room.Entity;
import androidx.room.PrimaryKey

@Entity(tableName = "projects")
data class Project (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "full_name") var fullName: String
)