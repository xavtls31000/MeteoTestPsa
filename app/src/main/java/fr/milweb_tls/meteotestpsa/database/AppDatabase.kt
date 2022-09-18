package fr.milweb_tls.meteotestpsa.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fr.milweb_tls.meteotestpsa.dao.DataMeteoDao
import fr.milweb_tls.meteotestpsa.dao.CityDao
import fr.milweb_tls.meteotestpsa.dao.WeatherDao
import fr.milweb_tls.meteotestpsa.entities.*
import fr.milweb_tls.meteotestpsa.interfaces.Constantes.Companion.DATABASE_NAME
import kotlinx.coroutines.CoroutineScope

/**
 * Created by xavier Mangiapanelli on 15/09/2022.
 */
@Database(
    entities = [
        Hourly::class, City::class, Weather::class],
    version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase(){

    // --- DAO ---
    abstract fun cityDao(): CityDao
    abstract fun dataMeteoDao(): DataMeteoDao
    abstract fun weatherDao(): WeatherDao

    companion object{

        // --- SINGLETON ---
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

    }
}