package com.melvin.carstracker.ui.car

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.melvin.carstracker.R
import com.melvin.carstracker.databinding.FragmentCarDetailBinding
import com.melvin.carstracker.databinding.FragmentNewCarFormBinding
import com.melvin.carstracker.ui.car.viewmodel.CarViewModel

class CarDetail : Fragment() {
    private lateinit var binding: FragmentCarDetailBinding

    //viewmodel
    private val viewModel: CarViewModel by activityViewModels {
        CarViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Return to previous view
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigate(R.id.action_carDetail_to_carContainer)
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)

        //Inflate the binding
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_car_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
    }

    private fun setViewModel() {
        binding.viewmodel = viewModel
    }
}