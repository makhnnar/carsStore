package com.pedrogomez.carsstore.domian.db

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class Category(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id:Long,
    @ColumnInfo(name = "name")
    val name:String,
    @ColumnInfo(name = "valueName")
    val value:String,
    @ColumnInfo(name = "editable")
    val editable:Boolean = true
)