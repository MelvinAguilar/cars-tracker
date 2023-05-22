package com.melvin.carstracker

import android.app.Application
import com.melvin.carstracker.data.cars
import com.melvin.carstracker.repositories.CarRepository

class CarReviewerApplication: Application() {
    val carRepository : CarRepository by lazy {
        CarRepository(cars)
    }
}