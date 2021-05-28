package com.pedrogomez.carsstore.view.detail

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.pedrogomez.carsstore.databinding.ViewDetailBinding

class DetailCarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle){

    var binding : ViewDetailBinding = ViewDetailBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    init{
        attrs.let {

        }
    }
}