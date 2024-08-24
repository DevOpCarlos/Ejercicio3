package com.carlosflores.ejercicio3.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.carlosflores.ejercicio3.AppDatabases.AppDatabase
import com.carlosflores.ejercicio3.R
import com.carlosflores.ejercicio3.Repositories.MainRepository
import com.carlosflores.ejercicio3.ViewModels.MainViewModel
import com.carlosflores.ejercicio3.ViewModels.ViewModelFactory
import com.carlosflores.ejercicio3.databinding.FragmentEjemploBinding

class EjemploFragment : DialogFragment() {

    private var _binding : FragmentEjemploBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel : MainViewModel by activityViewModels {
            ViewModelFactory(MainRepository(AppDatabase.getDatabase(requireContext())))
        }

        binding.textViewDato.text = viewModel.datoAPasar

        binding.botonSalir.setOnClickListener {

            this.dismiss()

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentEjemploBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    companion object {

        @JvmStatic
        fun newInstance() = EjemploFragment()
    }
}