package com.carlosflores.ejercicio3.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carlosflores.ejercicio3.Entities.Usuario
import com.carlosflores.ejercicio3.POJOs.UsuarioConPersona
import com.carlosflores.ejercicio3.databinding.ItemUsuarioBinding
import com.google.android.material.snackbar.Snackbar

class UsuariosAdapter(private var usuarios : ArrayList<UsuarioConPersona>) : RecyclerView.Adapter<UsuariosAdapter.ViewHolderUsuario>() {

    inner class ViewHolderUsuario(val binding : ItemUsuarioBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(usuario: UsuarioConPersona) {

            binding.apply {

                txtId.text = usuario.username
                txtUsername.text = usuario.primerNombre
                txtPassword.text = usuario.primerApellido

                botonAlerta.setOnClickListener {

                    Snackbar.make(binding.root, usuario.username, 1000).show()

                }

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUsuario {

        val binding = ItemUsuarioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderUsuario(binding)

    }

    override fun onBindViewHolder(holder: ViewHolderUsuario, position: Int) {

        holder.bind(usuarios[position])

    }

    override fun getItemCount(): Int {

        return usuarios.size

    }

    fun updateUsuarios(nuevosUsuarios : ArrayList<UsuarioConPersona>) {

        usuarios = nuevosUsuarios
        this.notifyDataSetChanged()

    }

}