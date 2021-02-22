package com.mm.t_ex.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Package(
    val compressed_file: String,
    val duration: String,
    val id: Int,
    val img: String,
    val title: String
) : Parcelable