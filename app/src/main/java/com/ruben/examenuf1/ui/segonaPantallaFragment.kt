package com.ruben.examenuf1.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ruben.examenuf1.R
import com.ruben.examenuf1.databinding.FragmentSegonaPantallaBinding
import com.ruben.examenuf1.viewmodel.GrupViewModelSelect
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ruben.examenuf1.adapter.AlumneAdapter
import com.ruben.examenuf1.viewmodel.SharedViewModel

class segonaPantallaFragment : Fragment() {

    private lateinit var binding: FragmentSegonaPantallaBinding
    private lateinit var grupViewModel: GrupViewModelSelect
    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_segona_pantalla, container, false
        )

        grupViewModel = ViewModelProvider(this).get(GrupViewModelSelect::class.java)

        viewManager = LinearLayoutManager(context)
        recyclerView = binding.recyclerViewGrups.apply {
            setHasFixedSize(true)
            layoutManager = viewManager

        }

        grupViewModel.obtenirAlumnes(requireContext())
            ?.observe(viewLifecycleOwner, Observer { alumneLlistat ->
                alumneLlistat?.let {
                    viewAdapter = AlumneAdapter(it) { selectedItem ->
                    }
                    recyclerView.adapter = viewAdapter
                }
            })
//        if (binding.checkBoxAprobados.isChecked) {
//            grupViewModel.obtenirAlumnesAprobats(requireContext(), notaApro)
//        } else {
//            grupViewModel.obtenirAlumnesSuspendidos(requireContext(), notaSus)
//        }

        return binding.root
    }
}