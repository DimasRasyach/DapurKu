package com.example.a2310511043_dimasrasyachnurfathi.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a2310511043_dimasrasyachnurfathi.Activities.detailresep
import com.example.a2310511043_dimasrasyachnurfathi.Adapter.ResepAdapter
import com.example.a2310511043_dimasrasyachnurfathi.Model.DataResep
import com.example.a2310511043_dimasrasyachnurfathi.Model.Resep
import com.example.a2310511043_dimasrasyachnurfathi.R

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

        resepList = DataResep().getDummyResep()

        resepAdapter = ResepAdapter(resepList) { resep ->
            val intent = Intent(requireContext(), detailresep::class.java)
            intent.putExtra("resep", resep)
            startActivity(intent)
        }

        recyclerView.adapter = resepAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val btnSemua = view.findViewById<Button>(R.id.btn_semua)
        val btnMakanan = view.findViewById<Button>(R.id.btn_mkn)
        val btnMinuman = view.findViewById<Button>(R.id.btn_mnn)
        val btnCemilan = view.findViewById<Button>(R.id.btn_cmln)
        val btnDessert = view.findViewById<Button>(R.id.btn_dst)

        btnSemua.setOnClickListener {
            filterResepByKategori("Semua")
        }

        btnMakanan.setOnClickListener {
            filterResepByKategori("Makanan")
        }

        btnMinuman.setOnClickListener {
            filterResepByKategori("Minuman")
        }

        btnDessert.setOnClickListener {
            filterResepByKategori("Dessert")
        }

        btnCemilan.setOnClickListener {
            filterResepByKategori("Cemilan")
        }
    }

    private fun filterResepByKategori(kategori: String) {
        val list = resepList
        val filteredList = if (kategori == "Semua") list else list.filter { it.kategori == kategori }
        resepAdapter.updateData(filteredList)
    }

}