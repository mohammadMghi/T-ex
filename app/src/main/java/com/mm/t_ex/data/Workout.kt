package com.mm.t_ex.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Workout(
    val compressed_file: String,
    val duration: String,
    val id: Int,
    val img: String,
    val moves: List<Move>,
    val title: String
): Parcelable