package com.mm.t_ex.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Move(
    val description: String,
    val duration: Duration,
    val `file`: String,
    val id: Int,
    val title: String
): Parcelable