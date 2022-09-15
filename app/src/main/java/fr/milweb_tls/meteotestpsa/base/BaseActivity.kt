package fr.milweb_tls.meteotestpsa.base

import android.content.BroadcastReceiver
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.play.core.tasks.OnFailureListener
import fr.milweb_tls.meteotestpsa.R
import fr.milweb_tls.meteotestpsa.database.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

abstract class BaseActivity: AppCompatActivity() {
    abstract class BaseActivity : AppCompatActivity() {

        abstract val fragmentLayout: Int

        private lateinit var receiver: BroadcastReceiver

        // LIFE CYCLE
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            this.setContentView(this.fragmentLayout)
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

}