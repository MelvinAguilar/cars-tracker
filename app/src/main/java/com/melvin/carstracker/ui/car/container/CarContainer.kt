package com.melvin.carstracker.ui.car.container

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.melvin.carstracker.R
import com.melvin.carstracker.data.carmodel.CarModel
import com.melvin.carstracker.databinding.FragmentCarContainerBinding
import com.melvin.carstracker.ui.car.viewmodel.CarViewModel


class CarContainer : Fragment() {

    //Binding
    private lateinit var binding: FragmentCarContainerBinding

    //viewmodel
    private val viewModel: CarViewModel by activityViewModels {
        CarViewModel.Factory
    }

    // UI
    private lateinit var newCarButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_car_container, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind()
        addListeners()
    }

    private fun bind()  {
        binding.let {
            newCarButton = it.newCarFormButton
        }
    }

    private fun addListeners() {
        newCarButton.setOnClickListener {
            viewModel.clearData()
            it.findNavController()
                .navigate(R.id.action_carContainer_to_newCarForm)
        }
    }
}