package com.pedrogomez.carsstore.domian.view

data class CarModel (
    val id:Long?,
    val cantSeats:Int?,
    val price:Double?,
    val isNew:Boolean?,
    val model:String?,
    val dateRelease:String?,
    val categoryId:Long?,
    val categoryName:String?,
    val valueName:String?,
    val valueQuantityId:Long?,
    val valueQuantity:Double?,
    val valueQuantityUnit:String?,
)