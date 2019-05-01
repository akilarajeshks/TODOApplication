package com.example.todoapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {


    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun addItem(){
        val todoViewModel = TODOViewModel()
        assert(todoViewModel.todoList.value!!.isEmpty())

        val todoItem = "new one"
        todoViewModel.addTodoItem(todoItem)

        val value = todoViewModel.todoList.value
        assert(value!!.size==1)
        assert(value[0] == todoItem)

        val secondTodo = "second item"
        todoViewModel.addTodoItem(secondTodo)

        val secondValue = todoViewModel.todoList.value
        assert(secondValue!!.size==2)
        assert(secondValue.last()==secondTodo)
    }

    @Test
    fun clearAllTest(){
        val todoViewModel = TODOViewModel()
        assert(todoViewModel.todoList.value!!.isEmpty())

        val todoItem = "item one"
        todoViewModel.addTodoItem(todoItem)

        val value = todoViewModel.todoList.value
        assert(value!!.size==1)
        assert(value[0] == todoItem)

        todoViewModel.clearAllTodo()

        val valueAfterClearing = todoViewModel.todoList.value
        assert(valueAfterClearing!!.isEmpty())
    }
}
