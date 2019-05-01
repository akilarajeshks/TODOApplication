package com.example.todoapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoRecyclerAdapter(todoList: List<String>) :
    RecyclerView.Adapter<TodoRecyclerAdapter.TodoViewHolder>() {

    private var list = todoList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.todo_list_item, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.todoItem.text = list[position]
    }

    fun loadTodoList(todoList: List<String>){
        this.list=todoList
    }


    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val todoItem: TextView = this.itemView.findViewById(R.id.todo_item)
    }
}