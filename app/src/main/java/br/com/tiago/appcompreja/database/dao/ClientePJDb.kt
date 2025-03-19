package br.com.tiago.appcompreja.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.tiago.appcompreja.model.ClientePJ
import br.com.tiago.appcompreja.model.Produto

@Database(entities = [ClientePJ::class], version = 1)
abstract class ClientePJDb: RoomDatabase() {
    abstract fun clientePJDao(): ClientePJDao

    companion object {
        private lateinit var instace: ClientePJDb

        fun getDatabase(context: Context): ClientePJDb {
            if (!::instace.isInitialized) {
                instace = Room.databaseBuilder(
                    context,
                    ClientePJDb::class.java,
                    "clientePJ_tb"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instace
        }
    }
}
