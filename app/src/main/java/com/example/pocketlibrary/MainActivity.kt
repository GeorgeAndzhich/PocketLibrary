package com.example.pocketlibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Task")

        var text = findViewById<EditText>(R.id.editTextTextPersonName)
        var actionButton = findViewById<Button>(R.id.button2)
       actionButton.setOnClickListener{

           var input = text.text.toString() // toString() because then it returns the string of text, else returns EditTextView object
           myRef.setValue(input)
       }
    }
}