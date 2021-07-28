package com.example.pocketlibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Task")

        var text = findViewById<EditText>(R.id.editTextTextPersonName)
        var actionButton = findViewById<Button>(R.id.button2)
        var delButton = findViewById<Button>(R.id.button3)
        var checkText = findViewById<TextView>(R.id.textView)

        text.setOnClickListener {
            if (delButton.visibility == Button.INVISIBLE) {
                delButton.visibility = Button.VISIBLE
            } else {
                delButton.visibility = Button.INVISIBLE
            }
        }
        actionButton.setOnClickListener {

            var input = text.text.toString() // toString() because then it returns the string of text, else returns EditTextView object
            myRef.setValue(input)
        }
        delButton.setOnClickListener {
            Toast.makeText(this, "Deleting action", Toast.LENGTH_LONG).show()
            myRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                   checkText.text = snapshot.getValue().toString()
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
        }
    }
}