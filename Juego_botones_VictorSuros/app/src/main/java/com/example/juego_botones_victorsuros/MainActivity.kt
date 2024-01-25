package com.example.juego_botones_victorsuros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val numBotones = 10
    private lateinit var llBotonera: LinearLayout
    private val boton = Random.nextInt(0, numBotones)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        llBotonera = findViewById(R.id.llBotonera)


        //Creamos las propiedades de layout que tendrán los botones.
        val lp = LinearLayout.LayoutParams(
            resources.getDimensionPixelSize(R.dimen.button_width),
            resources.getDimensionPixelSize(R.dimen.button_height)
        )
        llBotonera.gravity = Gravity.CENTER
        //Creamos los botones en bucle
        for (i in 0 until numBotones) {
            val button = Button(this)
            //Asignamos propiedades de layout al botón
            button.layoutParams = lp
            //Asignamos Texto al botón
            button.text = "Botón " + String.format("%02d", i)
            //Asignamos el Listener
            button.setOnClickListener(buttonClickListener(i))
            llBotonera.addView(button)
        }
    }
    private fun buttonClickListener(index: Int): View.OnClickListener {
        return View.OnClickListener {
            if (index == boton)
            {
                Toast.makeText(this@MainActivity,
                    "Me ENCONTRASTE",
                Toast.LENGTH_SHORT).show()
                val handler = Handler(Looper.getMainLooper())
                handler.postDelayed({
                    finish()
                }, 5000)


            }
            else {
                Toast.makeText(this@MainActivity,
                    "Sigue buscando",
                Toast.LENGTH_SHORT).show()
            }
        }
    }
}


