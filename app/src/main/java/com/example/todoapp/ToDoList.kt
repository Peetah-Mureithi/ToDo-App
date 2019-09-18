package com.example.todoapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todo.*
import java.time.LocalDateTime




class ToDoList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.todo)
        savebtn.setOnClickListener {
            var title=""
            title= title.toString()
          var prefs = getSharedPreferences("com.example.todoapp.sharedprefs", Context.MODE_PRIVATE)
            var todos = prefs.getStringSet("todostrings", setOf())?.toMutableSet()
            todos?.add(title)
            prefs.edit().putStringSet("todostrings",todos).apply()
            finish()

        }
    }


    //LocalDateTime? =LocalDateTime.now()


    //class  ToDoAdapter: ListAdapter
}
