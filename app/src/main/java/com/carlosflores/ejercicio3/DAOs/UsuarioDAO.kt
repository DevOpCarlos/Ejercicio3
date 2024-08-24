package com.carlosflores.ejercicio3.DAOs

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.carlosflores.ejercicio3.Entities.Usuario
import com.carlosflores.ejercicio3.POJOs.UsuarioConPersona
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDAO {

    @Insert
    fun insertUsuario(usuario : Usuario)

    @Update
    fun updateUsuario(usuario: Usuario)

    @Delete
    fun deleteUsuario(usuario: Usuario)

    @Query(" SELECT * FROM usuario ")
    fun selectAllUsuarios() : Flow<List<Usuario>>

    @Query(" SELECT * FROM usuario WHERE id = :id ")
    fun selectUsuario(id : Int) : Flow<Usuario>

    @Query("""
        
        SELECT usuario.username, persona.primer_nombre as primerNombre, persona.primer_apellido as primerApellido FROM usuario INNER JOIN persona ON usuario.id_persona = persona.id
        
    """)
    fun selectUsuariosConPersona() : Flow<List<UsuarioConPersona>>
}