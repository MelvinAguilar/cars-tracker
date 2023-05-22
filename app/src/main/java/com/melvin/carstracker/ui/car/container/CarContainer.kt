package com.melvin.carstracker.ui.car.container

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.melvin.carstracker.R
import com.melvin.carstracker.data.carmodel.CarModel
import com.melvin.carstracker.databinding.FragmentCarContainerBinding
import com.melvin.carstracker.ui.car.container.recyclerview.CarRecyclerViewAdapter
import com.melvin.carstracker.ui.car.viewmodel.CarViewModel


class CarContainer : Fragment() {

    //Binding and adapter
    private lateinit var binding: FragmentCarContainerBinding
    private lateinit var adapter: CarRecyclerViewAdapter

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

        setRecyclerView(view)
        bind()
        addListeners()
    }

    private fun setRecyclerView(view: View) {
        adapter = CarRecyclerViewAdapter { car ->
            showSelectedItem(car)
        }

        binding.recyclerMovies.adapter = adapter
        displayCars()
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

    private fun showSelectedItem(car: CarModel) {
        viewModel.setSelectedMovie(car)
        findNavController().navigate(R.id.action_carContainer_to_carDetail)
    }

    private fun displayCars() {
        adapter.setData(viewModel.getCars())
        adapter.notifyDataSetChanged()
    }
}