package com.example.notes.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Note(var title: String = "", var content: String = "") : Parcelable