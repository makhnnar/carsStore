package com.pedrogomez.carsstore.domian.db

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "car")
data class Car(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    val id:Long,
    @NonNull
    @ColumnInfo(name = "cantSeats")
    val cantSeats:Int,
    @NonNull
    @ColumnInfo(name = "price")
    val price:Double,
    @NonNull
    @ColumnInfo(name = "isNew")
    val isNew:Boolean,
    @NonNull
    @ColumnInfo(name = "model")
    val model:String,
    @NonNull
    @ColumnInfo(name = "dateRelease")
    val dateRelease:String,
    @NonNull
    @ColumnInfo(name = "idCategory")
    val idCategory:Long,
    @ColumnInfo(name = "idValue")
    val idValue:Long,

)