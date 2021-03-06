package com.pedrogomez.carsstore.view.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.pedrogomez.carsstore.domian.view.CarModel
import com.pedrogomez.carsstore.view.list.ListCarsView

class CarsAdapter(
        private var listener:ListCarsView.ItemListActions?
) : ListAdapter<CarModel, CarsVH>(CarsDC()) {

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): CarsVH {
        val inflater = LayoutInflater.from(
            parent.context
        )
        return CarsVH(
            inflater,
            parent
        )
    }

    override fun onBindViewHolder(
            holder: CarsVH,
            position: Int
    ) {
        val item = getItem(position)
        holder.setData(
            item,
            listener
        )
    }

}