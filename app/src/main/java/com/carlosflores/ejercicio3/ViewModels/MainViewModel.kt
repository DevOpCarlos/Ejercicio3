package com.carlosflores.ejercicio3.ViewModels

import androidx.annotation.Discouraged
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.carlosflores.ejercicio3.Entities.Usuario
import com.carlosflores.ejercicio3.POJOs.UsuarioConPersona
import com.carlosflores.ejercicio3.Repositories.MainRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val repo : MainRepository) : ViewModel() {

    var datoAPasar = ""

    fun selectAllUsuarios() : LiveData<List<Usuario>> {

        return repo.selectAllUsuarios().asLiveData(Dispatchers.IO)

    }

    fun selectUsuario(id : Int) : LiveData<Usuario> {

        return repo.selectUsuario(id).asLiveData(Dispatchers.IO)

    }

    fun selectUsuarioConPersona() : LiveData<List<UsuarioConPersona>> {

        return repo.selectUsuariosConPersona().asLiveData(Dispatchers.IO)

    }

}