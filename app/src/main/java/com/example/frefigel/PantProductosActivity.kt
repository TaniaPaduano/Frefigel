package com.example.frefigel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class PantProductosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pant_productos)

        val register = findViewById<ImageView>(R.id.add_btn)
        register.setOnClickListener{

            val pp= Intent(this,RegisterActivity::class.java)
            startActivity(pp)
        }
    }

}