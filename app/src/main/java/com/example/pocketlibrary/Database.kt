package com.example.pocketlibrary

import android.content.Context
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.security.AccessControlContext

class Database {
    val database = Firebase.database
    val reference = database.getReference("Books")

    fun Add(book: Book){
        reference.push().setValue(book)
    }

    fun Remove(book: Book, context: Context){
        if (reference.equals(book)){
            reference.removeValue()
        } else{
            Toast.makeText(context,"Book not found",Toast.LENGTH_SHORT).show()
        }
    }



}