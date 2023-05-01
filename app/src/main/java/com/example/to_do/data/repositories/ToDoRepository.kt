package com.example.to_do.data.repositories

import com.example.to_do.data.ToDoDao
import com.example.to_do.data.models.ToDoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

// ToDoDao hittades automatisk från DatabaseModule där du har intjecterad interface CRUD-TodoDao
// om du inte kopplar detta constructor from interface så kommer det inte funka exemple lägga task eller ta bort
// du måste anropa alla funktioner som du har gjort i Dao så att du inte missar det.
// skulle du vilja lägga till fler måste du göra först från interface annars blir det in your face
@ViewModelScoped
class ToDoRepository @Inject constructor(private val toDoDao: ToDoDao) {
    val getAllTasks: Flow<List<ToDoTask>> = toDoDao.getAllTasks()
    val sortByLowPriority: Flow<List<ToDoTask>> = toDoDao.sortByLowPriority()
    val sortByHighPriority: Flow<List<ToDoTask>> = toDoDao.sortByHighPriority()

    // För att hämta datan måste jag öppna pipe: Flow, ström av TodoTask för att leta efter uppgifter
    fun getSelectedTask(taskId: Int): Flow<ToDoTask> {
        return toDoDao.getSelectedTask(taskId = taskId)
    }

    // * inne i methoden måste du anropa från interface för att kunna uppdatera, tabort osv.
    suspend fun addTask(toDoTask: ToDoTask) {
        toDoDao.addTask(todoTask = toDoTask)
    }

    suspend fun updateTask(toDoTask: ToDoTask) {
        toDoDao.updateTask(toDoTask = toDoTask)
    }

    suspend fun deleteTask(toDoTask: ToDoTask) {
        toDoDao.deleteTask(toDoTask = toDoTask)
    }

    suspend fun deleteAllTasks() {
        toDoDao.deleteAllTasks()
    }

    fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>> {
        return toDoDao.searchDatabase(searchQuery = searchQuery)
    }
}