package fr.milweb_tls.meteotestpsa.util

import android.util.Log
import fr.milweb_tls.meteotestpsa.base.BaseActivity
import fr.milweb_tls.meteotestpsa.entities.City
import fr.milweb_tls.meteotestpsa.interfaces.Constantes.Companion.LOG_TAG
import fr.milweb_tls.meteotestpsa.reposytory.CityRepository

class InitCity() {

    fun initListCity(){

        var i = 1
        val listCity: MutableList<City> = java.util.ArrayList<City>()

        do {
            if (i==1) listCity.add(City(1,"31000","Toulouse"))
            if (i==2) listCity.add(City(2,"33000","Bordeaux"))
            if (i==3) listCity.add(City(3,"69000","Lyon"))
            if (i==4) listCity.add(City(4,"06000","Nice"))
            if (i==5) listCity.add(City(5,"44000","Nantes"))
            if (i==6) listCity.add(City(6,"75000","Paris"))
            if (i==7) listCity.add(City(7,"67000","Strasbourg"))
            if (i==8) listCity.add(City(8,"59000","Lille"))
            if (i==9) listCity.add(City(9,"13000","Marseille"))
            if (i==10) listCity.add(City(10,"83000","Toulon"))
            Log.d(LOG_TAG,"list: " + listCity)
            i++
        }
        while (i < 11)
        CityRepository(BaseActivity.databaseRoom.cityDao()).insertListAllCity(listCity)

    }


}
