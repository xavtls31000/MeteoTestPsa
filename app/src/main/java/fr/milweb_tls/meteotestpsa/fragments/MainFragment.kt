package fr.milweb_tls.meteotestpsa.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.viewModels
import fr.milweb_tls.meteotestpsa.MeteoTestPsaApplication
import fr.milweb_tls.meteotestpsa.R
import fr.milweb_tls.meteotestpsa.api.JsonDataMeteoApi
import fr.milweb_tls.meteotestpsa.base.BaseActivity
import fr.milweb_tls.meteotestpsa.entities.City
import fr.milweb_tls.meteotestpsa.interfaces.Constantes.Companion.LOG_TAG
import fr.milweb_tls.meteotestpsa.interfaces.Constantes.Companion.MSG_ERROR_INPUT_CITY
import fr.milweb_tls.meteotestpsa.recyclerview.CustomSpinnerCityAdapter
import fr.milweb_tls.meteotestpsa.reposytory.CityRepository
import fr.milweb_tls.meteotestpsa.viewModel.CityModelFactory
import fr.milweb_tls.meteotestpsa.viewModel.CityViewModel

/**
 * Created by xavier Mangiapanelli on 15/09/2022.
 */
class MainFragment : Fragment(), AdapterView.OnItemSelectedListener {

    var cityEditText: EditText? = null
    var codePostalEditText: EditText? = null
    private var spinnerAdapter: CustomSpinnerCityAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /** Inflate the layout for this fragment **/
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)
        val btnValidate = rootView.findViewById<Button>(R.id.input_ville_btn_validate)
        cityEditText = rootView.findViewById(R.id.input_city_city)
        codePostalEditText = rootView.findViewById(R.id.input_city_cp)

        //configureSpinner(rootView)
        configureViewModel(rootView)

        /** btn validate input city **/
        btnValidate.setOnClickListener {
            //Log.d(LOG_TAG,"ville: " + cityEditText!!.text.toString())
            if(cityEditText!=null && cityEditText!!.text.toString() != "") {
                val cityName = cityEditText!!.text.toString()
                val codePostal = codePostalEditText!!.text.toString()
                val city = City(0L,codePostal,cityName)

                /** save city object in BDD **/
                BaseActivity.databaseRoom.cityDao().insertCity(city)

                /** call API OpenWeather with city in parameter **/
                JsonDataMeteoApi(requireContext(), requireActivity().supportFragmentManager).getCurrentDataMeteoJson(city)

            } else Toast.makeText(context, MSG_ERROR_INPUT_CITY, Toast.LENGTH_SHORT).show()

        }
        return rootView
    }

    /** Configuring ViewModel **/
    private fun configureViewModel(view: View) {

        val cityViewModel: CityViewModel by requireActivity().viewModels {
            CityModelFactory((requireActivity().application as MeteoTestPsaApplication).repositoryCity)
        }

        /** observable : affichage de tous les produits des qu'un changement en BDD **/
        cityViewModel.allCity.observe(viewLifecycleOwner) { listCity ->
            /** Update the cached copy of the product in the adapter. **/
            //spinnerAdapter!!.submitList(listCity.sortedByDescending { it.name })
            configureSpinner(view)

        }

    }

    /** Configuring Spinner **/
    private fun configureSpinner(view: View){

        /** create list of spinner_mpVte **/
        val spinnerCity = view.findViewById<Spinner>(R.id.spinner_city)
        val listCity = CityRepository(BaseActivity.databaseRoom.cityDao()).getListAllCity()
        spinnerAdapter = CustomSpinnerCityAdapter(requireContext(), listCity)

        /** chargement spinner avec list des city et position sur la city séléctionnée **/
        spinnerCity.adapter = spinnerAdapter
        spinnerCity.onItemSelectedListener = this

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val city: City = parent?.getItemAtPosition(position) as City
        val imageEnseigne = requireView().findViewById<ImageView>(R.id.weather_spinner)

        /** show data in textWiew **/
        cityEditText!!.setText(city.name)
        codePostalEditText!!.setText(city.codePostal)


    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}