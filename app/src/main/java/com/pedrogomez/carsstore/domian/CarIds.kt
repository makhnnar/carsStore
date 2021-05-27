package com.pedrogomez.carsstore.domian

import androidx.room.ColumnInfo

data class CarIds(
    @ColumnInfo(name = "idCategory")
    val idCategory:Long,
    @ColumnInfo(name = "idValue")
    val idValue:Long
)
