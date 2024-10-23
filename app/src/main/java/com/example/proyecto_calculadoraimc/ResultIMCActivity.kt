package com.example.proyecto_calculadoraimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ResultIMCActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_imcactivity)

        val tvImc = findViewById<TextView>(R.id.tv_imc)
        val tvTitulo = findViewById<TextView>(R.id.tv_titulo)
        val tvDescripcion = findViewById<TextView>(R.id.tv_descripcion)
        val imc = intent.getDoubleExtra("IMC", 0.0)
        tvImc.text = String.format("%.2f", imc)

        when {
            imc in 0.0..18.49 -> {
                tvTitulo.text = getString(R.string.bajo_peso)
                tvTitulo.setTextColor(getColor(R.color.amarillo))
                tvDescripcion.text = getString(R.string.bajoPeso_ext)
            }
            imc in 18.5..24.99 ->{
                tvTitulo.text = getString(R.string.normal)
                tvTitulo.setTextColor(getColor(R.color.verde))
                tvDescripcion.text = getString(R.string.normal_ext)
            }
            imc in 24.5..29.99 ->{
                tvTitulo.text = getString(R.string.sobrepeso)
                tvTitulo.setTextColor(getColor(R.color.naranja))
                tvDescripcion.text = getString(R.string.sobrepeso_ext)
            }
            imc >= 30 -> {
                tvTitulo.text = getString(R.string.obesidad)
                tvTitulo.setTextColor(getColor(R.color.rojo))
                tvDescripcion.text = getString(R.string.obesidad_ext)
            }
        }

        val boton = findViewById<Button>(R.id.b_recalcular)
        boton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}