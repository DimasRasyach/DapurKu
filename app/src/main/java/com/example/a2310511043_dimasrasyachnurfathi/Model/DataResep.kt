package com.example.a2310511043_dimasrasyachnurfathi.Model

import com.example.a2310511043_dimasrasyachnurfathi.R

class DataResep {
    fun getDummyResep(): List<Resep> {
        return listOf(
            Resep(
                nama = "Nasi Goreng",
                deskripsi = "Nasi goreng sederhana namun lezat.",
                gambarResId = R.drawable.ic_launcher_background,
                kategori = "Makanan",
                bahan = """
                - 1 piring nasi putih
                - 2 siung bawang putih
                - 1 butir telur
                - Kecap manis secukupnya
                - Garam dan merica secukupnya
                - Minyak goreng
                """.trimIndent(),
                cara = """
                1. Tumis bawang putih cincang sampai harum.
                2. Masukkan telur, orak-arik hingga matang.
                3. Masukkan nasi putih, aduk rata.
                4. Tambahkan kecap, garam, dan merica. Aduk rata.
                5. Sajikan hangat.
                """.trimIndent()
            ),
            Resep(
                nama = "Es Teh Manis",
                deskripsi = "Minuman teh manis dingin yang menyegarkan.",
                gambarResId = R.drawable.ic_launcher_background,
                kategori = "Minuman",
                bahan = """
                - 1 kantong teh celup
                - 200 ml air panas
                - 2 sdm gula
                - Es batu secukupnya
                """.trimIndent(),
                cara = """
                1. Seduh teh celup dengan air panas.
                2. Tambahkan gula, aduk hingga larut.
                3. Dinginkan, lalu tambahkan es batu.
                4. Siap disajikan.
                """.trimIndent()
            ),
            Resep(
                nama = "Ayam Bakar",
                deskripsi = "Ayam bakar dengan bumbu khas dan aroma menggoda.",
                gambarResId = R.drawable.ic_launcher_background,
                kategori = "Makanan",
                bahan = """
                - 500 gram ayam
                - 3 siung bawang putih
                - 5 siung bawang merah
                - 3 sdm kecap manis
                - 1 sdt ketumbar
                - Garam dan gula secukupnya
                - Air dan minyak
                """.trimIndent(),
                cara = """
                1. Haluskan bumbu dan tumis hingga harum.
                2. Masukkan ayam, aduk hingga ayam berubah warna.
                3. Tambahkan air dan masak sampai ayam empuk.
                4. Oles ayam dengan bumbu, lalu bakar hingga kecoklatan.
                5. Sajikan dengan nasi hangat.
                """.trimIndent()
            )
        )
    }
}