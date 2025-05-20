package com.example.a2310511043_dimasrasyachnurfathi.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a2310511043_dimasrasyachnurfathi.Model.Resep
import com.example.a2310511043_dimasrasyachnurfathi.R

class ResepAdapter(
    private var resepList: List<Resep>,
    private val onDetailClick: (Resep) -> Unit
) : RecyclerView.Adapter<ResepAdapter.ResepViewHolder>() {

    inner class ResepViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgResep: ImageView = itemView.findViewById(R.id.img_resep)
        val tvNama: TextView = itemView.findViewById(R.id.tv_nama_resep)
        val tvDeskripsi: TextView = itemView.findViewById(R.id.tv_deskripsi_resep)
        val btnLihatDetail: Button = itemView.findViewById(R.id.btn_lihat_detail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResepViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_resep, parent, false)
        return ResepViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResepViewHolder, position: Int) {
        val resep = resepList[position]
        holder.imgResep.setImageResource(resep.gambarResId)
        holder.tvNama.text = resep.nama
        holder.tvDeskripsi.text = resep.deskripsi
        holder.btnLihatDetail.setOnClickListener {
            onDetailClick(resep)
        }
    }

    override fun getItemCount(): Int = resepList.size

    fun updateData(newList: List<Resep>) {
        resepList = newList
        notifyDataSetChanged()
    }
}
