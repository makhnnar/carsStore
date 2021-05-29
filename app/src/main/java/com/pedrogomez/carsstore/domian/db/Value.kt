package com.pedrogomez.carsstore.domian.db

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "value")
data class Value(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id:Long,
    @ColumnInfo(name = "quantity")
    val quantity:String,
    @ColumnInfo(name = "unit")
    val unit:String
)