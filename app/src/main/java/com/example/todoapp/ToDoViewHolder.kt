package com.example.tracomassign

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.ToDo

class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(todo:ToDo){
      //  itemView.findViewById<TextView>(R.id.createdDate).setText(todo.createdDate)
        itemView.findViewById<TextView>(R.id.title).setText(todo.title)
        itemView.findViewById<TextView>(R.id.description).setText(todo.description)
        itemView.findViewById<TextView>(R.id.dueDate).setText(todo.dueDate)

    }
}
