package com.melvin.carstracker.ui.car.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.melvin.carstracker.CarReviewerApplication
import com.melvin.carstracker.data.carmodel.CarModel
import com.melvin.carstracker.repositories.CarRepository

class CarViewModel(private val repository: CarRepository) : ViewModel() {

    // attributes
    var brand = MutableLiveData("")
    var model = MutableLiveData("")
    var status = MutableLiveData("")

    fun getCars() = repository.getCars()

    fun addCars(_car : CarModel) = repository.addCar(_car)

    //validation and creation of a model
    fun createCar() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val newCar = CarModel(
            brand.value!!,
            model.value!!
        )

        addCars(newCar)
        clearData()

        status.value = MOVIE_CREATED
    }

    fun validateData(): Boolean {
        when {
            brand.value.isNullOrEmpty() -> return false
            model.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData() {
        brand.value = ""
        model.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    fun setSelectedMovie(car: CarModel) {
        brand.value = car.brand
        model.value = car.model
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val carRepository = (this[APPLICATION_KEY] as CarReviewerApplication).carRepository
                CarViewModel(carRepository)
            }
        }

        const val MOVIE_CREATED = "Movie created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}