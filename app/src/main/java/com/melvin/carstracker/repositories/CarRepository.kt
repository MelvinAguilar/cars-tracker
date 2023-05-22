package com.melvin.carstracker.repositories

import com.melvin.carstracker.data.carmodel.CarModel

class CarRepository(private val cars: MutableList<CarModel>) {
    //Get all Cars
    fun getCars() = cars

    //Add a car to the mutable list
    fun addCar(_card: CarModel) = cars.add(_card)
}