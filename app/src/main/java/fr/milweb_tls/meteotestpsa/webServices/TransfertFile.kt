package fr.milweb_tls.meteotestpsa.webServices

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import fr.milweb_tls.meteotestpsa.base.BaseActivity
import fr.milweb_tls.meteotestpsa.entities.City
import fr.milweb_tls.meteotestpsa.entities.CurrentWeather
import fr.milweb_tls.meteotestpsa.entities.Weather
import fr.milweb_tls.meteotestpsa.fragments.MainFragment
import fr.milweb_tls.meteotestpsa.fragments.MeteoCityFragment
import fr.milweb_tls.meteotestpsa.interfaces.Constantes
import fr.milweb_tls.meteotestpsa.interfaces.Constantes.Companion.KEY_API
import fr.milweb_tls.meteotestpsa.interfaces.Constantes.Companion.MSG_ERROR_NOT_CONNECT
import fr.milweb_tls.meteotestpsa.interfaces.Constantes.Companion.MSG_OK_SAVE_WEATHER
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

@Suppress("SENSELESS_COMPARISON")
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
        val call: Call<CurrentWeather> =
            service.getDataMeteoForCity(city.name, "metric" , "fr", KEY_API)

        call.enqueue(object : Callback<CurrentWeather> {

            override fun onResponse(call: Call<CurrentWeather>, response: Response<CurrentWeather>) {

                if (response.code() == 200) {

                    val weatherResponse: CurrentWeather = response.body()!!
                    val date = dateFormat.format(Date()).toString()

                    /** Create Weather Object from response **/
                    val weather = Weather(
                        0,
                        date,
                        weatherResponse.weather[0].main.toString(),
                        weatherResponse.weather[0].description.toString(),
                        weatherResponse.weather[0].icon.toString(),
                        city.name,
                        weatherResponse.main!!.temp,
                        weatherResponse.main!!.temp_min,
                        weatherResponse.main!!.temp_max
                    )

                    /** Save weather object in BDD **/
                    WeatherRepository(BaseActivity.databaseRoom.weatherDao()).insertWeather(weather)
                    Toast.makeText(context, MSG_OK_SAVE_WEATHER, Toast.LENGTH_SHORT).show()

                    /** Call MeteoCityFragment() **/
                    gotoFragmentMeteoCityFragment(weather,1)

                } else {
                    /** get weather if off line **/
                    getWeatherIfOffLine(city)

                }
            }

            override fun onFailure(call: Call<CurrentWeather>, t: Throwable) {

                /** get weather if off line **/
                getWeatherIfOffLine(city)
            }
        })
    }

    fun getWeatherIfOffLine(city:City){

        /** find weather fot city selected **/
        val weather = WeatherRepository(BaseActivity.databaseRoom.weatherDao()).getWeatherForCity(city.name)

        if(weather!=null) {
            gotoFragmentMeteoCityFragment(weather,0)
        } else {
            Toast.makeText(context, MSG_ERROR_NOT_CONNECT, Toast.LENGTH_SHORT).show()
            StaticMethode.startTransactionFragment(fragmentManager, MainFragment(),null)
        }

    }

    fun gotoFragmentMeteoCityFragment(weather: Weather, errorType: Int){

        /** Call MeteoCityFragment() passing Weather object in bundle **/
        val bundle = Bundle()
        bundle.putSerializable("weather", weather)
        bundle.putInt("errorType", errorType)
        StaticMethode.startTransactionFragment(fragmentManager, MeteoCityFragment(), bundle)

    }


}