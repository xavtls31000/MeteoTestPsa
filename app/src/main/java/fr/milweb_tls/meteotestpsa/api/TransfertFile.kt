package fr.milweb_tls.meteotestpsa.api

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import fr.milweb_tls.meteotestpsa.base.BaseActivity
import fr.milweb_tls.meteotestpsa.entities.City
import fr.milweb_tls.meteotestpsa.entities.CurrentWeather
import fr.milweb_tls.meteotestpsa.entities.Weather
import fr.milweb_tls.meteotestpsa.fragments.MeteoCityFragment
import fr.milweb_tls.meteotestpsa.interfaces.Constantes
import fr.milweb_tls.meteotestpsa.interfaces.Constantes.Companion.KEY_API
import fr.milweb_tls.meteotestpsa.interfaces.Constantes.Companion.LOG_TAG
import fr.milweb_tls.meteotestpsa.interfaces.MeteoTestPsaServices
import fr.milweb_tls.meteotestpsa.reposytory.WeatherRepository
import fr.milweb_tls.meteotestpsa.util.StaticMethode
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
class TransfertFile(var context: Context, var fragmentManager: FragmentManager) {


    val dateFormat = SimpleDateFormat("dd/MM/yyyy")

    /** Call Api OpenWeather for 1 city **/
    fun getCurrentData(city: City) {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Constantes.BASE_URL_SERVER)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service: MeteoTestPsaServices = retrofit.create(MeteoTestPsaServices::class.java)
        val call: Call<CurrentWeather> = service.getDataMeteoForCity(city.name, KEY_API)

        call.enqueue(object : Callback<CurrentWeather> {

            override fun onResponse(call: Call<CurrentWeather>, response: Response<CurrentWeather>) {

                if (response.code() == 200) {

                    val weatherResponse: CurrentWeather = response.body()!!
                    val date = dateFormat.format(Date()).toString()
                    Log.d(LOG_TAG, "date: " + date)
                    val weather = Weather(
                        0,
                        date,
                        weatherResponse.weather[0].main.toString(),
                        weatherResponse.weather[0].description.toString(),
                        weatherResponse.weather[0].icon.toString(),
                        city.name,
                    )
                    /** Save weather object in BDD **/
                    WeatherRepository(BaseActivity.databaseRoom.weatherDao()).insertWeather(weather)
                    Log.d(LOG_TAG, "weatherResponse: " + weatherResponse.weather[0])
                    Log.d(LOG_TAG, "weather: " + weather.toString())
                    /** Call MeteoCityFragment() passing Weather object in bundle **/
                    val bundle = Bundle()
                    bundle.putSerializable("city", city)
                    bundle.putSerializable("weather", weather)
                    StaticMethode.startTransactionFragment(fragmentManager, MeteoCityFragment(), bundle)






                } else {
                    Log.d(LOG_TAG, "error response: " + response.raw())
                }
            }

            override fun onFailure(call: Call<CurrentWeather>, t: Throwable) {
                Log.d(LOG_TAG, "error response: " + t)
            }
        })
    }


}