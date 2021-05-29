package com.pedrogomez.carsstore.domian.db

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "car")
data class Car(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id:Long,
    @ColumnInfo(name = "cantSeats")
    val cantSeats:String,
    @ColumnInfo(name = "price")
    val price:String,
    @ColumnInfo(name = "isNew")
    val isNew:Boolean,
    @ColumnInfo(name = "model")
    val model:String,
    @ColumnInfo(name = "dateRelease")
    val dateRelease:String,
    @ColumnInfo(name = "idCategory")
    val idCategory:Long,
    @ColumnInfo(name = "idValue")
    var idValue:Long?,

)