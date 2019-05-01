package com.example.todoapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TODOViewModel : ViewModel() {
    val todoList: MutableLiveData<List<String>> = MutableLiveData<List<String>>().apply{
        value = (listOf())
    }

    fun addTodoItem(todo: String) {
        val list = todoList.value
        val mutableList = list!!.toMutableList()
        mutableList.add(todo)
        todoList.postValue(mutableList)
    }
}