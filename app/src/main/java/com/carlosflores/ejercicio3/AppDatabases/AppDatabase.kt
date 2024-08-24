package com.carlosflores.ejercicio3.AppDatabases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.carlosflores.ejercicio3.DAOs.UsuarioDAO
import com.carlosflores.ejercicio3.Entities.Persona
import com.carlosflores.ejercicio3.Entities.Usuario

@Database(entities = [Usuario::class, Persona::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun UsuarioDAO() : UsuarioDAO

    companion object {

        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getDatabase(context : Context) : AppDatabase {

            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "AppDatabase"
                ).build()

                INSTANCE = instance
                instance

            }

        }

    }

}