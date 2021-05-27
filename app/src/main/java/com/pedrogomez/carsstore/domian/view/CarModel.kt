package com.pedrogomez.carsstore.domian.view

import androidx.room.ColumnInfo

data class CarModel (
    @ColumnInfo(name = "id")
    val id:Long,
    @ColumnInfo(name = "cantSeats")
    val cantSeats:Int,
    @ColumnInfo(name = "price")
    val price:Double,
    @ColumnInfo(name = "isNew")
    val isNew:Boolean,
    @ColumnInfo(name = "model")
    val model:String,
    @ColumnInfo(name = "dateRelease")
    val dateRelease:String,
    @ColumnInfo(name = "categoryName")
    val categoryName:String?,
    @ColumnInfo(name = "valueName")
    val valueName:String?,
    @ColumnInfo(name = "valueQuantity")
    val valueQuantity:Double?,
    @ColumnInfo(name = "valueUnit")
    val valueUnit:String?,
)