package com.pedrogomez.carsstore.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pedrogomez.carsstore.databinding.FragmentDetailBinding
import com.pedrogomez.carsstore.presentation.CarsViewModel
import org.koin.android.viewmodel.ext.android.getViewModel

class DetailCarFrament : Fragment(){

    private val carsViewModel by lazy {
        requireParentFragment().getViewModel<CarsViewModel>()
    }

    private lateinit var binding: FragmentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentDetailBinding.inflate(
            inflater,
            container,
            false
        )
        val view = binding.root
        initObservers()
        return view
    }

    private fun initObservers(){

    }

}