package com.emdasoft.pokemonapp2023.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database([PokeNameDbModel::class, PokeInfoDbModel::class], version = 1, exportSchema = false)
abstract class PokeDatabase : RoomDatabase() {

    abstract fun pokeListDao(): PokeListDao

    companion object {
        private var INSTANCE: PokeDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "pokemon.db"

        fun getInstance(application: Application): PokeDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
            }
            val db = Room.databaseBuilder(
                application,
                PokeDatabase::class.java,
                DB_NAME
            ).build()
            INSTANCE = db
            return db
        }
    }
}