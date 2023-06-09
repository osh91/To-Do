package com.example.to_do.data


import androidx.room.*
import com.example.to_do.data.models.ToDoTask
import kotlinx.coroutines.flow.Flow


// Det är här man inser, remove ect.
@Dao
interface ToDoDao {
    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllTasks(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM todo_table WHERE id=:taskId")
    fun getSelectedTask(taskId: Int): Flow<ToDoTask>

    /*
    * onConflict = OnConflictStrategy.IGNORE is an argument passed to the @Insert annotation.
    * It specifies what should happen if there is a conflict when inserting the object into the database.
    * In this case, it is set to IGNORE, which means that if the object being inserted already exists in the database,
    * the insert operation will be ignored and the existing object will be left unchanged.
    * */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(todoTask: ToDoTask)

    @Update
    suspend fun updateTask(toDoTask: ToDoTask)

    @Delete
    suspend fun deleteTask(toDoTask: ToDoTask)

    @Query("DELETE FROM todo_table")
    suspend fun deleteAllTasks()

    @Query("SELECT * FROM todo_table WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun sortByLowPriority(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    fun sortByHighPriority(): Flow<List<ToDoTask>>


}