package com.example.todoapp

import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.tracomassign.TodoViewHolder


class ToDoAdapter: ListAdapter<ToDo, TodoViewHolder>(object : DiffUtil.ItemCallback<ToDo>()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo, parent, false)
        return TodoViewHolder(view)
    }


}
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind( getitem(position))
    }







