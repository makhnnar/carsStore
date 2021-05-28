package com.pedrogomez.carsstore.view.editcreate

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.pedrogomez.carsstore.databinding.ViewEditCreateBinding

class EditCreateCarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle){

    var binding : ViewEditCreateBinding = ViewEditCreateBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    init{
        attrs.let {

        }
    }
}