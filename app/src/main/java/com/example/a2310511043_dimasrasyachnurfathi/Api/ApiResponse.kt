package com.example.a2310511043_dimasrasyachnurfathi.Api

import android.os.Parcelable
import com.example.a2310511043_dimasrasyachnurfathi.Model.Resep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ApiResponse(

    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("limit")
    val limit: Int? = null,

    @field:SerializedName("skip")
    val skip: Int? = null,

    @field:SerializedName("recipes")
    val products: List<Resep?>? = null
) : Parcelable