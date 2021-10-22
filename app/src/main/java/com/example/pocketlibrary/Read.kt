package com.example.pocketlibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue

class Read : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read2)

        // Declaring elements
        val Search = findViewById<EditText>(R.id.editTextTextPersonName3)
        var button = findViewById<Button>(R.id.button4)
        var test = findViewById<TextView>(R.id.textView2)

        val db  = Database()

        button.setOnClickListener{
           var queried:String = test.text.toString()
            if (queried.isNotEmpty())
            {
                db.reference.child(queried).get().addOnSucessListener{
                    if (it.exists()){
                        val bookTitle = it.child("title").value
                        test.text = bookTitle.toString()
                    }
                 }.addOnFailureListener{
                     Toast.makeText(this,"Book not found",Toast.LENGTH_SHORT).show()
                }
                }
            }
        }
    }
