package br.com.tiago.appcompreja.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.tiago.appcompreja.model.Produto

@Database(entities = [Produto::class], version = 4)
abstract class ProdutoDb: RoomDatabase() {
    abstract fun produtoDao(): ProdutoDao

    companion object {
        private lateinit var instace: ProdutoDb

        fun getDatabase(context: Context): ProdutoDb {
            if (!::instace.isInitialized) {
                instace = Room.databaseBuilder(
                    context,
                    ProdutoDb::class.java,
                    "produto_tb"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instace
        }
    }
}
