package com.example.pocketlibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bookName = findViewById<EditText>(R.id.editTextTextPersonName)
        var author  = findViewById<EditText>(R.id.editTextTextPersonName2)
        var comment = findViewById<TextInputLayout>(R.id.TextInput)
        var actionButton = findViewById<Button>(R.id.button2)
        var checkText = findViewById<TextView>(R.id.textView)

        var db = Database()

        actionButton.setOnClickListener {
            var book = Book(bookName.text.toString(),author.text.toString(),comment.toString())
            db.Add(book)
        }


    }
}