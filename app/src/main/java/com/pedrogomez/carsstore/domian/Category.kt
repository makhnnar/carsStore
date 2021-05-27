package com.pedrogomez.carsstore.domian

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class Category(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    val id:Long,
    @NonNull
    @ColumnInfo(name = "name")
    val name:String,
    // estos tres valores pueden ser una nueva
    // tabla pero por rapidez del desarrollo
    // estaran incluidos dentro de la categoria
    @ColumnInfo(name = "valueName")
    val valueName:String,
    @ColumnInfo(name = "valueQuantity")
    val valueQuantity:Double,
    @ColumnInfo(name = "valueUnits")
    val valueUnits:String
)