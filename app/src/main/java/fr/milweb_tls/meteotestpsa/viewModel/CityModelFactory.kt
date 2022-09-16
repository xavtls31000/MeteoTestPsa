package fr.milweb_tls.meteotestpsa.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.milweb_tls.meteotestpsa.reposytory.CityRepository
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class CityModelFactory(private val repository: CityRepository) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CityViewModel::class.java)) {
            return CityViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}