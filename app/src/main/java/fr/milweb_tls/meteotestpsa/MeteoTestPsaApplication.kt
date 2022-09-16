package fr.milweb_tls.meteotestpsa

import android.app.Application
import fr.milweb_tls.meteotestpsa.database.AppDatabase
import fr.milweb_tls.meteotestpsa.reposytory.CityRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MeteoTestPsaApplication :Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    /**
     * Utilisation de lazy pour que la base de données et le référentiel ne soient créés
     * que lorsqu'ils sont nécessaires plutôt qu'au démarrage de l'application
     */
    val database by lazy { AppDatabase.getDatabase(this, applicationScope) }
    val repositoryCity by lazy { CityRepository(database.cityDao()) }

    companion object{

        @get:Synchronized
        lateinit var initializer : MeteoTestPsaApplication
            private set
    }
    override fun onCreate() {
        super.onCreate()

        initializer = this

    }
}