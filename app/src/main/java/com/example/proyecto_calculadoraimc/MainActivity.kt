package com.example.proyecto_calculadoraimc

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class MainActivity : AppCompatActivity() {
    lateinit var cv_hombre: CardView
    lateinit var cv_mujer: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val rsHeight = findViewById<RangeSlider>(R.id.rs_altura)
        cv_hombre = findViewById(R.id.cv_hombre)
        cv_mujer = findViewById(R.id.cv_mujer)
        var currentHeight: Int
        var currentWeight = 60
        var currentAge = 30
        var altura = 0.0
        var tvHeight = findViewById<TextView>(R.id.tv_altura)
        var tvPeso = findViewById<TextView>(R.id.tv_peso)
        var tvEdad = findViewById<TextView>(R.id.tv_edad)

        rsHeight.addOnChangeListener {_, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            altura = currentHeight/100.0
            tvHeight.text = currentHeight.toString() + " cm"
        }
        val botonPesoMas = findViewById<FloatingActionButton>(R.id.fab_peso_mas)
        botonPesoMas.setOnClickListener {
            currentWeight += 1
            tvPeso.text = currentWeight.toString()
        }
        val botonPesoMenos = findViewById<FloatingActionButton>(R.id.fab_peso_menos)
        botonPesoMenos.setOnClickListener {
            currentWeight -= 1
            tvPeso.text = currentWeight.toString()
        }
        val botonEdadMas = findViewById<FloatingActionButton>(R.id.fab_edad_mas)
        botonEdadMas.setOnClickListener {
            currentAge += 1
            tvEdad.text = currentAge.toString()
        }
        val botonEdadMenos = findViewById<FloatingActionButton>(R.id.fab_edad_menos)
        botonEdadMenos.setOnClickListener {
            currentAge -= 1
            tvEdad.text = currentAge.toString()
        }
        cv_hombre.setOnClickListener {
            cv_hombre.setCardBackgroundColor(ContextCompat.getColor(applicationContext,R.color.fondo_cvs))
            cv_mujer.setCardBackgroundColor(ContextCompat.getColor(applicationContext,R.color.fondo_csv_oscuro))
        }
        cv_mujer.setOnClickListener {
            cv_hombre.setCardBackgroundColor(ContextCompat.getColor(applicationContext,R.color.fondo_csv_oscuro))
            cv_mujer.setCardBackgroundColor(ContextCompat.getColor(applicationContext,R.color.fondo_cvs))
        }
        val botonCalcular = findViewById<Button>(R.id.fab_calcular)
        botonCalcular.setOnClickListener {
            val imc = currentWeight/(altura*altura)
            val intent = Intent(this, ResultIMCActivity::class.java)
            intent.putExtra("IMC", imc)
            startActivity(intent)
        }
    }
}