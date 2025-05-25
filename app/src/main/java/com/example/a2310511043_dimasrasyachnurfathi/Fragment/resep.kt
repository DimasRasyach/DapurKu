package com.example.a2310511043_dimasrasyachnurfathi.Fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a2310511043_dimasrasyachnurfathi.Activities.detailresep
import com.example.a2310511043_dimasrasyachnurfathi.Adapter.ResepAdapter
import com.example.a2310511043_dimasrasyachnurfathi.Api.ApiConfig
import com.example.a2310511043_dimasrasyachnurfathi.Model.Resep
import com.example.a2310511043_dimasrasyachnurfathi.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class resep : Fragment() {
    private var resepList: List<Resep> = emptyList()
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
        resepAdapter = ResepAdapter(resepList) { resep ->
            val intent = Intent(requireContext(), detailresep::class.java)
            intent.putExtra("resep", resep)
            startActivity(intent)
        }
        recyclerView.adapter = resepAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        getDataFromApi()

        val btnAll = view.findViewById<Button>(R.id.btn_all)
        val btnDinner = view.findViewById<Button>(R.id.btn_Dinner)
        val btnLunch = view.findViewById<Button>(R.id.btn_Lunch)
        val btnSnack = view.findViewById<Button>(R.id.btn_Snack)
        val btnDessert = view.findViewById<Button>(R.id.btn_Dessert)
        val btnAppetizer = view.findViewById<Button>(R.id.btn_Appetizer)
        val btnBreakfast = view.findViewById<Button>(R.id.btn_Breakfast)

        btnAll.setOnClickListener { filterResepByKategori("All") }
        btnDinner.setOnClickListener { filterResepByKategori("Dinner") }
        btnLunch.setOnClickListener { filterResepByKategori("Lunch") }
        btnSnack.setOnClickListener { filterResepByKategori("Snack") }
        btnDessert.setOnClickListener { filterResepByKategori("Dessert") }
        btnAppetizer.setOnClickListener { filterResepByKategori("Appetizer") }
        btnBreakfast.setOnClickListener { filterResepByKategori("Breakfast") }
    }

    private fun getDataFromApi() {
        val client = ApiConfig.apiService.getAllResep()
        client.enqueue(object : Callback<com.example.a2310511043_dimasrasyachnurfathi.Api.ApiResponse> {
            override fun onResponse(
                call: Call<com.example.a2310511043_dimasrasyachnurfathi.Api.ApiResponse>,
                response: Response<com.example.a2310511043_dimasrasyachnurfathi.Api.ApiResponse>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.products?.filterNotNull() ?: emptyList()
                    resepList = data
                    resepAdapter.updateData(resepList)
                } else {
                    Toast.makeText(requireContext(), "Gagal memuat data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(
                call: Call<com.example.a2310511043_dimasrasyachnurfathi.Api.ApiResponse>,
                t: Throwable
            ) {
                Toast.makeText(requireContext(), "Gagal koneksi: ${t.message}", Toast.LENGTH_SHORT).show()
                Log.e("API_ERROR", t.message ?: "Unknown error")
            }
        })
    }

    private fun filterResepByKategori(kategori: String) {
        val filteredList = if (kategori == "All") {
            resepList
        } else {
            resepList.filter { resep ->
                resep.mealType?.any { it.equals(kategori, ignoreCase = true) } == true
            }
        }
        resepAdapter.updateData(filteredList)
    }
}