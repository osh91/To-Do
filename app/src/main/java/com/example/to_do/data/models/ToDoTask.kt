package com.example.to_do.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.to_do.util.Constants.DATABASE_TABLE

// we are telling ROOM this is a table in database

@Entity(tableName = DATABASE_TABLE)
data class ToDoTask(
    // * den autogenererar primary key id
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority,

    )