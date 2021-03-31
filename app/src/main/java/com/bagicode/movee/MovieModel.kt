package com.bagicode.movee

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Menambahkan parcelable agar ketika di-klik itu langsung lempar value-nya, tidak menggunakan Intent putExtra
 * Tapi langsung semua build data-nya
 */
@Parcelize
/**
 * Terdapat aturan yang harus dipenuhi ketika membuat parcelable di Kotlin
 * - Buka build.gradle (Module)
 * - Tambahkan androidExtensions { experimental = true } di dalam blok android
 */

data class MovieModel(
    // Dalam Film, biasanya terdapat atribut sebagaimana berikut..
    var id: String? = "",
    var title: String? = "",
    var desc: String = "",
    var genre: String? = "",
    var poster: Int? = 0,
    var trailer: Int? = 0,
    var rating: Float
) : Parcelable