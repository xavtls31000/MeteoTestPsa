package fr.milweb_tls.meteotestpsa.base

import android.content.BroadcastReceiver
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.milweb_tls.meteotestpsa.database.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

/**
 * Created by xavier Mangiapanelli on 15/09/2022.
 */
abstract class BaseActivity: AppCompatActivity() {

        private lateinit var receiver: BroadcastReceiver

        // LIFE CYCLE
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

             val applicationScope = CoroutineScope(SupervisorJob())

            databaseRoom = AppDatabase.getDatabase(this, applicationScope)

        }

        override fun onDestroy() {
            super.onDestroy()
            unregisterReceiver(receiver)
        }

        companion object {

            lateinit var databaseRoom: AppDatabase

        }

}