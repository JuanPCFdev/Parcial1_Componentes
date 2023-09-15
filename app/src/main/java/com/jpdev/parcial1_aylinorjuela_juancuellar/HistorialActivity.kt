package com.jpdev.parcial1_aylinorjuela_juancuellar

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class HistorialActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial)

        val editTextHistorial = findViewById<EditText>(R.id.EditTextHistorial)
        var Texto: String? = intent.extras?.getString("Text")

        editTextHistorial.setText(Texto)

    }
}