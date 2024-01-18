package com.ruben.examenuf1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ruben.examenuf1.R
import com.ruben.examenuf1.databinding.FragmentPrimeraPantallaBinding
import com.ruben.examenuf1.viewmodel.AlumneViewModelInsert

class primeraPantallaFragment : Fragment() {

    private lateinit var binding: FragmentPrimeraPantallaBinding
    private lateinit var alumneviewmodelinsert: AlumneViewModelInsert

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_primera_pantalla, container, false
        )
        alumneviewmodelinsert = ViewModelProvider(this).get(AlumneViewModelInsert::class.java)

        binding.buttonInsert.setOnClickListener {

            val nom = binding.nomEditTextAlumne.text.toString()
            val grup = binding.grupEditTextAlumne.text.toString()
            val preu = binding.notaEditTextAlumne.text.toString().toInt()

            alumneviewmodelinsert.newAlumn(requireContext(), nom, grup, preu)
            //Navigation.findNavController(it).navigate(R.id.action_insertCatalegFragment_to_catalegFragment)
        }

        return binding.root
    }
}