package fr.milweb_tls.meteotestpsa.interfaces

import androidx.annotation.WorkerThread
import fr.milweb_tls.meteotestpsa.entities.DataMeteo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Streaming

interface MeteoTestPsaServices {


    @GET("")
    @Streaming
    @WorkerThread
    fun getDataMeteoForCodePostal(@Path("codePostal") dataMeteo: String): Call<DataMeteo>

}