package com.mm.t_ex.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Duration(
    val duration: String
): Parcelable