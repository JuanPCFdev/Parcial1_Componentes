package com.jpdev.parcial1_aylinorjuela_juancuellar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.text.SimpleDateFormat
import java.util.Date

class AhorroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ahorro)

        var monto: Int? = intent.extras?.getInt("Monto")
        var Texto: String? = intent.extras?.getString("Text")

        val btnGuardarAhorro = findViewById<Button>(R.id.BtnGuardarAhorro)
        val editTextAhorro = findViewById<EditText>(R.id.EditTextAhorro)

        btnGuardarAhorro.setOnClickListener {
            var ahorro: Int? = editTextAhorro.text.toString().toInt()
            var abono = ahorro
            if (ahorro != null && ahorro > 0 && monto != null && monto > 0) {
                ahorro += monto
            }
            val fechaActual = Date()
            val formato = SimpleDateFormat("dd/MM/yyyy")
            val fechaActualTexto = formato.format(fechaActual)
            Texto += "\n($fechaActualTexto) Se ha abonado $abono"
            val intent = Intent(this, PaginaPrincipalActivity::class.java)
            intent.putExtra("Ahorro", ahorro)
            intent.putExtra("Text",Texto)
            startActivity(intent)
        }


    }
}