package com.example.todoapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_todolist.*



class TODOListFragment : Fragment() {

    lateinit var todoViewModel: TODOViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todolist, container, false)
    }



    override fun onStart() {
        super.onStart()

        todoViewModel = ViewModelProviders.of(this.activity!!)[TODOViewModel::class.java]

        add_fab.setOnClickListener {
            findNavController().navigate(R.id.action_TODOListFragment_to_addNewFragment)
        }

        clear_all_btn.setOnClickListener {
            todoViewModel.clearAllTodo()
        }

        recycler_todo.apply {
            adapter =TodoRecyclerAdapter(
                todoViewModel.todoList.value!!
            )
            layoutManager=LinearLayoutManager(this.context)
        }

        todoViewModel.todoList.observe(this, Observer {
            (recycler_todo.adapter as TodoRecyclerAdapter).loadTodoList(it)
            recycler_todo.adapter!!.notifyDataSetChanged()

            clear_all_btn.isEnabled = it.isNotEmpty()
        })

    }
}
