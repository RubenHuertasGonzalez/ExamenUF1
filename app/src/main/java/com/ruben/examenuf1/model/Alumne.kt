package com.ruben.examenuf1.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alumn")
data class Alumne(

    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "group")
    var group: String,
    @ColumnInfo(name = "note")
    var note: Int)
{
    @PrimaryKey(autoGenerate = true)
    var Id: Int? = null
}
