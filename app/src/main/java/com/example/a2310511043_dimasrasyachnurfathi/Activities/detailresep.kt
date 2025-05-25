package com.example.a2310511043_dimasrasyachnurfathi.Activities

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
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
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        val btnBack = findViewById<Button>(R.id.btn_back)
        btnBack.setOnClickListener {
            finish()
        }

        val imgResep = findViewById<ImageView>(R.id.img_detail)
        val tvNama = findViewById<TextView>(R.id.tv_nama_detail)
        val tvRating = findViewById<TextView>(R.id.tv_rating)
        val tvBahan = findViewById<TextView>(R.id.tv_bahan_detail)
        val tvCara = findViewById<TextView>(R.id.tv_cara_detail)

        resep?.let {

            Glide.with(this)
                .load(it.image)
                .into(imgResep)

            tvNama.text = it.name
            tvRating.text = "Rating: ${it.rating} ★"
            tvBahan.text = it.ingredients?.joinToString(separator = "\n") { "• $it" } ?: ""

            tvCara.text = it.instructions?.mapIndexed { index, step -> "${index + 1}. $step" }
                ?.joinToString(separator = "\n") ?: ""
        }
    }
}


