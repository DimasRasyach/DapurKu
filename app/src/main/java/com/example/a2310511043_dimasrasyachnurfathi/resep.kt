package com.example.a2310511043_dimasrasyachnurfathi

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a2310511043_dimasrasyachnurfathi.Adapter.ResepAdapter
import com.example.a2310511043_dimasrasyachnurfathi.Model.Resep
import kotlin.jvm.java

class resep : Fragment() {
    private lateinit var resepList: List<Resep>
    private lateinit var resepAdapter: ResepAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_resep, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rv_resep)

        resepList = getDummyResep()

        resepAdapter = ResepAdapter(resepList) { resep ->

        }

        recyclerView.adapter = resepAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val btnSemua = view.findViewById<Button>(R.id.btn_semua)
        val btnMakanan = view.findViewById<Button>(R.id.btn_mkn)
        val btnMinuman = view.findViewById<Button>(R.id.btn_mnn)

        btnSemua.setOnClickListener {
            filterResepByKategori("Semua")
        }

        btnMakanan.setOnClickListener {
            filterResepByKategori("Makanan")
        }

        btnMinuman.setOnClickListener {
            filterResepByKategori("Minuman")
        }
    }

    private fun filterResepByKategori(kategori: String) {
        val list = resepList
        val filteredList = if (kategori == "Semua") list else list.filter { it.kategori == kategori }
        resepAdapter.updateData(filteredList)
    }

    private fun getDummyResep(): List<Resep> {
        return listOf(
            Resep(
                nama = "Nasi Goreng",
                deskripsi = "Nasi goreng sederhana",
                gambarResId = R.drawable.ic_launcher_background,
                kategori = "Makanan"
            ),
            Resep(
                nama = "Es Teh",
                deskripsi = "Minuman segar",
                gambarResId = R.drawable.ic_launcher_background,
                kategori = "Minuman"
            ),
            Resep(
                nama = "Ayam Bakar",
                deskripsi = "Ayam bakar lezat",
                gambarResId = R.drawable.ic_launcher_background,
                kategori = "Makanan"
            )
        )
    }
}