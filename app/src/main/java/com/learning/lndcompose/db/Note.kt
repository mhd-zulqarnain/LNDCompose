package com.learning.lndcompose.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
class Note(
    @PrimaryKey(autoGenerate = true)
    val id:Int =0,
    val title:String,
    val description:String,
    val color:Int,
) {
}