package fr.milweb_tls.meteotestpsa.interfaces

interface Constantes {

    companion object{

        // Generale
        const val LOG_TAG = "XXXALL"
        const val DATABASE_NAME = "meteoTestPsa.db"
        const val KEY_API = "4c68a8d20b9e4fdef11ce6f8eda1415f"
        const val BASE_URL_SERVER = "https://api.openweathermap.org/"

        // Messages error
        const val MSG_ERROR_INPUT_CITY = "Saisie ville incorrecte"

        // Messages
        const val MSG_OK_SAVE_WEATHER = "Méteo enregistrée"
    }


}