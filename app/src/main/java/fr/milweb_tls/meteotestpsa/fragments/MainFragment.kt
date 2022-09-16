package fr.milweb_tls.meteotestpsa.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import fr.milweb_tls.meteotestpsa.R
import fr.milweb_tls.meteotestpsa.api.JsonDataMeteoApi
import fr.milweb_tls.meteotestpsa.base.BaseActivity
import fr.milweb_tls.meteotestpsa.entities.City
import fr.milweb_tls.meteotestpsa.interfaces.Constantes.Companion.LOG_TAG
import fr.milweb_tls.meteotestpsa.interfaces.Constantes.Companion.MSG_ERROR_INPUT_CITY
import fr.milweb_tls.meteotestpsa.recyclerview.CustomSpinnerCityAdapter
import fr.milweb_tls.meteotestpsa.reposytory.CityRepository

/**
 * Created by xavier Mangiapanelli on 15/09/2022.
 */
class MainFragment : Fragment(), AdapterView.OnItemSelectedListener {

    var cityEditText: EditText? = null
    var codePostalEditText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)
        val btnValidate = rootView.findViewById<Button>(R.id.input_ville_btn_validate)
        cityEditText = rootView.findViewById(R.id.input_city_city)
        codePostalEditText = rootView.findViewById(R.id.input_city_cp)

        configureSpinner(rootView)

        // btn validate input city
        btnValidate.setOnClickListener {
            Log.d(LOG_TAG,"ville: " + cityEditText!!.text.toString())
            if(cityEditText!=null && cityEditText!!.text.toString() != "") {
                val cityName = cityEditText!!.text.toString()
                val codePostal = codePostalEditText!!.text.toString()
                BaseActivity.databaseRoom.cityDao().insertCity(City(0L,codePostal,cityName))
                JsonDataMeteoApi(requireContext(), requireActivity().supportFragmentManager).getProductJson(cityName)

            } else Toast.makeText(context, MSG_ERROR_INPUT_CITY, Toast.LENGTH_SHORT).show()

        }
        return rootView
    }

    private fun configureSpinner(view: View){
        // create list of spinner_mpVte
        val spinnerCity = view.findViewById<Spinner>(R.id.spinner_city)
        val listCity = CityRepository(BaseActivity.databaseRoom.cityDao()).getListAllCity()
        val dataAdapter = CustomSpinnerCityAdapter(requireContext(), listCity)

        // chargement spinner avec list des enseignes et position sur l'enseigne séléctionnée
        spinnerCity.adapter = dataAdapter
        spinnerCity.onItemSelectedListener = this

    }


    companion object {

        var animationList = intArrayOf(
            R.anim.layout_animation_up_to_down,
            R.anim.layout_animation_right_to_left,
            R.anim.layout_animation_down_to_up,
            R.anim.layout_animation_left_to_right
        )
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val city: City = parent?.getItemAtPosition(position) as City
        Log.d(LOG_TAG,"city : " + city.name)
        val imageEnseigne = requireView().findViewById<ImageView>(R.id.weather_spinner)
        cityEditText!!.setText(city.name)

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}