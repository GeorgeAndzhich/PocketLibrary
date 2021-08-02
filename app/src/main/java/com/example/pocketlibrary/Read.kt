package com.example.pocketlibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

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


    }

}