package fr.milweb_tls.meteotestpsa.interfaces

interface Constantes {

    companion object{

        // Generale
        const val LOG_TAG = "XXXALL"
        const val DATABASE_NAME = "meteoTestPsa.db"
        const val KEY_API = "4c68a8d20b9e4fdef11ce6f8eda1415f"
        //const val SERVER_ADDRESS = "https://api.openweathermap.org/data/2.5/onecall?lat=43.58&lon=1.44&APPID=4c68a8d20b9e4fdef11ce6f8eda1415f"
        const val SERVER_ADDRESS = "https://api.openweathermap.org/data/2.5/weather?q=london&APPID=4c68a8d20b9e4fdef11ce6f8eda1415f/"
        const val BASE_URL_SERVER = "https://api.openweathermap.org/"
        const val SERVER_ADDRESS_TEST = "https://world.openfoodfacts.org/api/v0/product/3046920029780.json"
    }   //43.58974151491995, 1.4496635242393672


}