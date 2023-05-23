package com.example.to_do.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_do.data.models.ToDoTask
import com.example.to_do.data.repositories.ToDoRepository
import com.example.to_do.util.RequestState
import com.example.to_do.util.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShareViewModel @Inject constructor(private val repository: ToDoRepository) : ViewModel() {

    // * Reminder
    // * MutableStateOf - for UI
    // * MutableStateFlow - for streaming like ROOM / database

    // När user trycker på searchIcon då byter det component till searchbar
    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)

    val searchTextState: MutableState<String> = mutableStateOf("")

    // tänk dig du har private String _foo = ""
    // den skapar variabel allTask och den är tomt från början, initialize empty list
    // ! Anropas RquestState för att det flickar lite pga Listan var empty, fin justrering
    private val _allTasks = MutableStateFlow<RequestState<List<ToDoTask>>>(RequestState.Idle)
    val allTasks: StateFlow<RequestState<List<ToDoTask>>> = _allTasks

    fun getAllTasks() {
        _allTasks.value = RequestState.Loading
        try {
            viewModelScope.launch {
                repository.getAllTasks.collect {
                    _allTasks.value = RequestState.Success(it)
                }
            }
        } catch (e: Exception) {
            _allTasks.value = RequestState.Error(e)
        }
    }
}