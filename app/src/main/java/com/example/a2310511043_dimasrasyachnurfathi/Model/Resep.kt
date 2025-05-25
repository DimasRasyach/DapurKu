    package com.example.a2310511043_dimasrasyachnurfathi.Model

    import android.os.Parcelable
    import com.google.gson.annotations.SerializedName
    import kotlinx.android.parcel.Parcelize

    @Parcelize
    data class Resep(
        @SerializedName("id")
        val id: Int? = null,

        @SerializedName("name")
        val name: String? = null,

        @SerializedName("ingredients")
        val ingredients: List<String?>? = null,

        @SerializedName("instructions")
        val instructions: List<String?>? = null,

        @SerializedName("prepTimeMinutes")
        val prepTimeMinutes: Int? = null,

        @SerializedName("cookTimeMinutes")
        val cookTimeMinutes: Int? = null,

        @SerializedName("servings")
        val servings: Int? = null,

        @SerializedName("difficulty")
        val difficulty: String? = null,

        @SerializedName("cuisine")
        val cuisine: String? = null,

        @SerializedName("caloriesPerServing")
        val caloriesPerServing: Int? = null,

        @SerializedName("tags")
        val tags: List<String?>? = null,

        @SerializedName("userId")
        val userId: Int? = null,

        @SerializedName("image")
        val image: String? = null,

        @SerializedName("rating")
        val rating: Double? = null,

        @SerializedName("reviewCount")
        val reviewCount: Int? = null,

        @SerializedName("mealType")
        val mealType: List<String?>? = null

    ) : Parcelable
