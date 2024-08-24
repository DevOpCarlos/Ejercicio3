package com.carlosflores.ejercicio3.Repositories

import com.carlosflores.ejercicio3.AppDatabases.AppDatabase
import com.carlosflores.ejercicio3.Entities.Usuario
import com.carlosflores.ejercicio3.POJOs.UsuarioConPersona
import kotlinx.coroutines.flow.Flow

class MainRepository(private val db : AppDatabase) {

    fun selectAllUsuarios() : Flow<List<Usuario>> {

        return db.UsuarioDAO().selectAllUsuarios()

    }

    fun selectUsuario(id : Int) : Flow<Usuario> {

        return db.UsuarioDAO().selectUsuario(id)

    }

    fun selectUsuariosConPersona() : Flow<List<UsuarioConPersona>> {

        return db.UsuarioDAO().selectUsuariosConPersona()

    }

}