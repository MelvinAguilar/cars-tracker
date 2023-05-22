package com.melvin.carstracker.ui.car.newcar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.melvin.carstracker.R
import com.melvin.carstracker.databinding.FragmentNewCarFormBinding
import com.melvin.carstracker.ui.car.viewmodel.CarViewModel


class NewCarForm : Fragment() {


    //Binding
    private lateinit var binding: FragmentNewCarFormBinding

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
                findNavController().navigate(R.id.action_newCarForm_to_carContainer)
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)

        //Inflate the binding
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_new_car_form, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()
    }


    private fun setViewModel() {
        binding.viewmodel = viewModel
    }

    private fun observeStatus() {
        viewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(CarViewModel.WRONG_INFORMATION) -> {
                    Toast.makeText(
                        requireContext(), "Wrong information", Toast.LENGTH_LONG
                    ).show()
                    viewModel.clearStatus()
                }
                status.equals(CarViewModel.MOVIE_CREATED) -> {

                    Toast.makeText(
                        requireContext(), "Car created", Toast.LENGTH_LONG
                    ).show()
                    viewModel.clearStatus()

                    findNavController().popBackStack()
                }
            }
        }
    }


}