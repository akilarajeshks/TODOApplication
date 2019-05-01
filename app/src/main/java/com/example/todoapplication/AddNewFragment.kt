package com.example.todoapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add_new.*


class AddNewFragment : Fragment() {

    lateinit var todoViewModel: TODOViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_new, container, false)
    }

    override fun onStart() {
        super.onStart()

        todo_text.requestFocus()
        showKeyboard()
        todoViewModel = ViewModelProviders.of(this.activity!!)[TODOViewModel::class.java]

        add_btn.setOnClickListener {
            addTodoItem()
            findNavController().popBackStack()
        }
    }

    private fun addTodoItem() {
        todo_text.clearFocus()
        closeKeyboard()
        todoViewModel.addTodoItem(todo_text.text.toString())
    }

    private fun showKeyboard() {
        val inputMethodManager = context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }

    private fun closeKeyboard() {
        val inputMethodManager = context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
    }
}
