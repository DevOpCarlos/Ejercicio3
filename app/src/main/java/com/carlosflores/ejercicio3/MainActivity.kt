package com.carlosflores.ejercicio3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.carlosflores.ejercicio3.Adapters.UsuariosAdapter
import com.carlosflores.ejercicio3.AppDatabases.AppDatabase
import com.carlosflores.ejercicio3.Entities.Usuario
import com.carlosflores.ejercicio3.Fragments.EjemploFragment
import com.carlosflores.ejercicio3.Repositories.MainRepository
import com.carlosflores.ejercicio3.ViewModels.MainViewModel
import com.carlosflores.ejercicio3.ViewModels.ViewModelFactory
import com.carlosflores.ejercicio3.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val adapter = UsuariosAdapter(ArrayList())

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        val viewModel : MainViewModel by viewModels {
            ViewModelFactory(MainRepository(AppDatabase.getDatabase(this)))
        }

        binding.botonAbrirFragment.setOnClickListener {

            viewModel.datoAPasar = "Hola, este dato viene del activity"

            EjemploFragment().show(supportFragmentManager, "ejemploFragment")

        }

        viewModel.selectUsuarioConPersona().observe(this, Observer { listaUsuarios ->

            adapter.updateUsuarios(ArrayList(listaUsuarios))

        })

    }
}