package com.pedrogomez.carsstore.view.list

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.pedrogomez.carsstore.databinding.ViewListBinding

class ListCarsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle){

    var binding : ViewListBinding = ViewListBinding.inflate(
        LayoutInflater.from(context), this
    )

    var btnUp : FloatingActionButton? = null

    var btnAdd : FloatingActionButton? = null

    var rvItems : RecyclerView? = null

    var loader : ProgressBar? = null

    init{
        attrs.let {

        }
        btnUp = binding.btnToTop
        btnAdd = binding.btnAdd
        rvItems = binding.rvItems
        loader = binding.pbLoader
    }
}