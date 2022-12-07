package com.example.frefigel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val home01 = findViewById<ImageView>(R.id.home01)
        val producto = findViewById<ImageView>(R.id.crearproducto)
        val car = findViewById<ImageView>(R.id.carrito)
        val per = findViewById<ImageView>(R.id.crearproducto)
        val perfil = findViewById<ImageView>(R.id.perfil)
        ////


        home01.setOnClickListener{
            val h1 = Intent(this,Panthome::class.java)
            startActivity(h1)
        }
        producto.setOnClickListener{

            val b= Intent(this,PantProductosActivity::class.java)
            startActivity(b)
        }
        car.setOnClickListener{
            val c= Intent(this, Carrito::class.java)
            startActivity(c)
        }

        per.setOnClickListener{
            val d = Intent (this,InicioProductos::class.java)
            startActivity(d)
        }
       perfil.setOnClickListener{
           val e = Intent(this,ProfileActivity::class.java)
           startActivity(e)
       }
    }
}