package com.LuluNaurahHukama.tugas2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.LuluNaurahHukama.tugas2.adapter.BukuAdapter
import com.LuluNaurahHukama.tugas2.model.ModelBuku

private  lateinit var rev_data : RecyclerView

class RecycleViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle_view)
        rev_data = findViewById(R.id.rv_data)

        val listBuku = listOf(
            ModelBuku(judul = "Buku Laskar Pelangi 1 ", penulis = "Lulu Naurah Hukama"),
            ModelBuku(judul = "Buku Laskar Pelangi 2 ", penulis = "Lulu Naurah Hukama"),
            ModelBuku(judul = "Buku Laskar Pelangi 3 ", penulis = "Lulu Naurah Hukama"),
            ModelBuku(judul = "Buku Laskar Pelangi 4 ", penulis = "Lulu Naurah Hukama"),
            ModelBuku(judul = "Buku Laskar Pelangi 5 ", penulis = "Lulu Naurah Hukama"),
            ModelBuku(judul = "Buku Laskar Pelangi 6 ", penulis = "Lulu Naurah Hukama"),
            ModelBuku(judul = "Buku Laskar Pelangi 7 ", penulis = "Lulu Naurah Hukama"),
            ModelBuku(judul = "Buku Laskar Pelangi 8 ", penulis = "Lulu Naurah Hukama"),
        )

        val nBukuAdapter = BukuAdapter(listBuku)
        rev_data.apply {
            layoutManager = LinearLayoutManager(this@RecycleViewActivity)
            adapter = nBukuAdapter
        }
        //kita array list
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rv_buah)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}