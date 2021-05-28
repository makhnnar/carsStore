package com.pedrogomez.carsstore.view.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.pedrogomez.carsstore.databinding.FragmentListBinding
import com.pedrogomez.carsstore.presentation.CarsViewModel
import org.koin.android.viewmodel.ext.android.getViewModel

class ListCarsFragment : Fragment(){

    private val carsViewModel by lazy {
        requireParentFragment().getViewModel<CarsViewModel>()
    }

    private lateinit var binding: FragmentListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentListBinding.inflate(
            inflater,
            container,
            false
        )
        val view = binding.root
        initObservers()
        return view
    }

    private fun initObservers(){
        carsViewModel.carsList.observe(
            viewLifecycleOwner,
            Observer {

            }
        )
    }

}