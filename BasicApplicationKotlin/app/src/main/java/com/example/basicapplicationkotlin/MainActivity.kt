package com.example.basicapplicationkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // Kode Lateinit
    private lateinit var inputEditText: EditText
    private lateinit var sendButton: Button
    private lateinit var helloTextView: TextView

    private fun initComponents(){
        inputEditText = findViewById(R.id.inputEditText)
        sendButton = findViewById(R.id.sendButton)
        helloTextView = findViewById(R.id.helloTextView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()

        helloTextView.text = "Hi"

        sendButton.setOnClickListener {
            val name = inputEditText.text.toString()
            helloTextView.text = "Hi, $name"
        }
    }
}