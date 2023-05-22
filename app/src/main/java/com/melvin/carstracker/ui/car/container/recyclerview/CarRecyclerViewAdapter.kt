package com.melvin.carstracker.ui.car.container.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.melvin.carstracker.data.carmodel.CarModel
import com.melvin.carstracker.databinding.ItemCarBinding

class CarRecyclerViewAdapter(private val onClickMovie: (CarModel) -> Unit) :
    RecyclerView.Adapter<CarRecyclerViewHolder>() {

    private val cars = ArrayList<CarModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarRecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCarBinding.inflate(inflater, parent, false)
        return CarRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int = cars?.size ?: 0

    override fun onBindViewHolder(holder: CarRecyclerViewHolder, position: Int) {
        val car = cars[position]
        holder.bind(car, onClickMovie)
    }

    fun setData(carList: List<CarModel>) {
        cars.clear()
        cars.addAll(carList)
    }

}