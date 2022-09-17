package fr.milweb_tls.meteotestpsa.interfaces

import androidx.annotation.WorkerThread
import fr.milweb_tls.meteotestpsa.entities.CurrentWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Streaming

interface MeteoTestPsaServices {


    /** Config call Api retrofit for 1 city with keyApi **/
    @GET("data/2.5/weather?")
    @Streaming
    @WorkerThread
    fun getDataMeteoForCity(@Query("q") city: String?,
                            @Query("APPID") app_id: String?): Call<CurrentWeather>



}