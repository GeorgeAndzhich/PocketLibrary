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
        val name = findViewById<TextView>(R.id.textView6)
        val author = findViewById<TextView>(R.id.textView7)
        val comment = findViewById<TextView>(R.id.textView8)
        var button = findViewById<Button>(R.id.button4)
        var test = findViewById<TextView>(R.id.textView2)

        val db = Database()
        button.setOnClickListener {
            db.reference.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val searchData = Search.text.toString()
                    snapshot.children.forEach {
                       test.text=it.child("name").getValue<Book>().toString()
                    }

                }
                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })



            }

        }
    }
