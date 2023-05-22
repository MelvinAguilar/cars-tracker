package com.melvin.carstracker.ui.car.container.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.melvin.carstracker.data.carmodel.CarModel
import com.melvin.carstracker.databinding.ItemCarBinding

class CarRecyclerViewHolder(private val binding: ItemCarBinding): RecyclerView.ViewHolder (binding.root) {
    fun bind (car: CarModel, clickListener: (CarModel) -> Unit) {
        binding.carBrand.text = car.brand
        binding.carModel.text = car.model
        binding.carCardView.setOnClickListener { clickListener(car) }
    }
}