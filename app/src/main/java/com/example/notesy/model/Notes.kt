package com.example.notesy.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Notes")
class Notes (

    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    var title: String,
    var subtitle: String,
    var notes: String,
    var date: String
    ):Parcelable