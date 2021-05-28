package com.pedrogomez.carsstore.view.list.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.pedrogomez.carsstore.R
import com.pedrogomez.carsstore.databinding.ViewHolderItemBinding
import com.pedrogomez.carsstore.domian.view.CarModel

class CarsVH(
    inflater: LayoutInflater,
    parent: ViewGroup
) : RecyclerView.ViewHolder(
    inflater.inflate(
        R.layout.view_holder_item,
        parent,
        false
    )
) {

    private var context : Context

    private var binding: ViewHolderItemBinding? = null

    private var data: CarModel? = null

    private var model : AppCompatTextView? = null

    private var price : AppCompatTextView? = null

    private var category : AppCompatTextView? = null

    init {
        binding = ViewHolderItemBinding.bind(itemView)
        context = parent.context
        model = binding?.tvModel
        price = binding?.tvPrice
        category = binding?.tvCategory
    }

    fun setData(item: CarModel?) {

    }

}