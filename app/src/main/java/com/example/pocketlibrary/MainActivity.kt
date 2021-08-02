package com.example.pocketlibrary

import android.content.Intent
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
        var comment = findViewById<EditText>(R.id.editTextTextMultiLine)
        var actionButton = findViewById<Button>(R.id.button2)
        var checkText = findViewById<TextView>(R.id.textView)
        var readButton = findViewById<Button>(R.id.button7)

        var db = Database()

        actionButton.setOnClickListener {
            var book = Book(bookName.text.toString(),author.text.toString(),comment.text.toString())
            db.Add(book)
        }
        readButton.setOnClickListener{
            Intent(this,Read::class.java).also { startActivity(it) }
        }

    }
}