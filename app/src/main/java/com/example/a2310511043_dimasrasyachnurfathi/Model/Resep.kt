    package com.example.a2310511043_dimasrasyachnurfathi.Model

    import android.os.Parcelable
    import kotlinx.android.parcel.Parcelize

    @Parcelize
    data class Resep(
        val nama: String,
        val deskripsi: String,
        val gambarResId: Int,
        val kategori: String,
        val bahan: String,
        val cara: String
    ) : Parcelable
