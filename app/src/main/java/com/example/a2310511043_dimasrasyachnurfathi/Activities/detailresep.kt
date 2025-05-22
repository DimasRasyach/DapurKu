package com.example.a2310511043_dimasrasyachnurfathi.Activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a2310511043_dimasrasyachnurfathi.Fragment.resep
import com.example.a2310511043_dimasrasyachnurfathi.Model.Resep
import com.example.a2310511043_dimasrasyachnurfathi.R

class detailresep : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailresep)
        val resep = intent.getParcelableExtra<Resep>("resep")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detailresep)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imgResep = findViewById<ImageView>(R.id.img_detail)
        val tvNama = findViewById<TextView>(R.id.tv_nama_detail)
        val tvDeskripsi = findViewById<TextView>(R.id.tv_deskripsi_detail)
        val tvBahan = findViewById<TextView>(R.id.tv_bahan_detail)
        val tvCara = findViewById<TextView>(R.id.tv_cara_detail)

        resep?.let {
            imgResep.setImageResource(it.gambarResId)
            tvNama.text = it.nama
            tvDeskripsi.text = it.deskripsi
            tvBahan.text = it.bahan
            tvCara.text = it.cara
        }
    }
}


