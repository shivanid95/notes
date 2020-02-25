package com.example.notes.data

import android.os.Parcelable
import android.text.format.DateUtils
import kotlinx.android.parcel.Parcelize
import java.time.LocalDateTime
import java.util.*

/**
 * Note class: for saving a single note unit
 */
@Parcelize
data class Note(var title: String = "", var content: String = "", var date: Date = Date(), var isBookmarked: Boolean = false) : Parcelable