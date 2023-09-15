package com.jpdev.parcial1_aylinorjuela_juancuellar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class PaginaPrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_principal)

        val monedero = Monedero(0)//Creando objeto Monedero

        var Texto: String? = intent.extras?.getString("Text")
        if(Texto == null){
            Texto = "Lista de Transacciones"
        }

        val btnAhorrar = findViewById<Button>(R.id.BtnAhorrar)
        val btnRetirar = findViewById<Button>(R.id.BtnRetirar)
        val btnHistorial = findViewById<Button>(R.id.BtnHistorial)
        val editTextSaldo = findViewById<EditText>(R.id.EditTextSaldo)

        val saldo: Int? = intent.extras?.getInt("Ahorro")

        if(saldo != null && saldo > 0){
            monedero.Saldo = saldo
            editTextSaldo.setText("${monedero.Saldo}")
        }else{
            editTextSaldo.setText("${monedero.Saldo}")
        }

        btnAhorrar.setOnClickListener {
            val intent = Intent(this, AhorroActivity::class.java)
            intent.putExtra("Monto",monedero.Saldo)
            intent.putExtra("Text",Texto)
            startActivity(intent)
        }

        btnRetirar.setOnClickListener {
            val intent = Intent(this, RetirarActivity::class.java)
            intent.putExtra("Monto",monedero.Saldo)
            intent.putExtra("Text",Texto)
            startActivity(intent)
        }

        btnHistorial.setOnClickListener {
            val intent = Intent(this, HistorialActivity::class.java)
            intent.putExtra("Text",Texto)
            startActivity(intent)
        }
    }
}