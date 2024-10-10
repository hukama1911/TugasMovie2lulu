package com.LuluNaurahHukama.tugas2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Detailmovie : AppCompatActivity() {
    private lateinit var txtmovie : TextView
    private lateinit var imgmovie : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailmovie)

        txtmovie= findViewById(R.id.txtmovie)
        imgmovie = findViewById(R.id.imgmovie)

        val detailText = intent.getStringExtra("judul")
        val detailImg = intent.getIntExtra("image",0)

        txtmovie.setText(detailText)
        imgmovie.setImageResource(detailImg)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}