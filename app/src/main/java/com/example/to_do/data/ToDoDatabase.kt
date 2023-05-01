package com.example.to_do.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.to_do.data.models.ToDoTask

// * You have to make a "server" that you are making a table with loads of functions and fun!
// * Denna hör till Dao där du har gjort ToDoDao
@Database(entities = [ToDoTask::class], version = 1, exportSchema = false)
abstract class ToDoDatabase : RoomDatabase() {

    // return interface ToDoDao där du har gjort CRUD funktionerna
    abstract fun toDoDao(): ToDoDao

}
