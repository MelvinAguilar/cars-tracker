package com.melvin.carstracker.ui.car

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.melvin.carstracker.R
import com.melvin.carstracker.databinding.FragmentCarDetailBinding

class CarDetail : Fragment() {
    private lateinit var binding: FragmentCarDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_car_detail, container, false)
        return binding.root
    }
}