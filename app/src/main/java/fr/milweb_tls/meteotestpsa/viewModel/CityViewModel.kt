package fr.milweb_tls.meteotestpsa.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import fr.milweb_tls.meteotestpsa.entities.City
import fr.milweb_tls.meteotestpsa.reposytory.CityRepository

class CityViewModel( private val repository: CityRepository) : ViewModel() {

    val allCity: LiveData<List<City>> = repository.allCity.asLiveData()
}