package com.example.todoapp

import java.time.LocalDateTime

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale


data class ToDo(val title:String, val description:String,val createdDate:String ,val dueDate:String)

//LocalDateTime? = LocalDateTime.now()