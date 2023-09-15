package com.jpdev.parcial1_aylinorjuela_juancuellar

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.text.SimpleDateFormat
import java.util.Date

class RetirarActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retirar)

        val editTextRetiro = findViewById<EditText>(R.id.EditTextRetiro)
        val btnRetirar = findViewById<Button>(R.id.BtnRetirar)
        var Texto: String? = intent.extras?.getString("Text")

        btnRetirar.setOnClickListener {
            var ret:Int = 0
            var monto: Int? = intent.extras?.getInt("Monto")
            var ahorro: Int? = editTextRetiro.text.toString().toInt()
            if (ahorro != null && monto != null && ahorro < monto) {
                if (ahorro != null && ahorro > 0 && monto != null && monto > 0) {
                    ret = monto - ahorro
                    if(ret <= 0){
                        ret = 0
                    }
                    val fechaActual = Date()
                    val formato = SimpleDateFormat("dd/MM/yyyy")
                    val fechaActualTexto = formato.format(fechaActual)
                    Texto += "\n($fechaActualTexto) Se ha Retirado $ahorro"
                    val intent = Intent(this, PaginaPrincipalActivity::class.java)
                    intent.putExtra("Ahorro", ret)
                    intent.putExtra("Text",Texto)
                    startActivity(intent)
                }
            }else{
                val intent = Intent(this, PaginaPrincipalActivity::class.java)
                if (monto != null) {
                    ret = monto
                }
                intent.putExtra("Ahorro", ret)
                intent.putExtra("Text",Texto)
                startActivity(intent)
            }

        }

    }
}