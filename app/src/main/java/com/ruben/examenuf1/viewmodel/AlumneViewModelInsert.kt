package com.ruben.examenuf1.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ruben.examenuf1.model.Alumne
import com.ruben.examenuf1.repository.Repository

class AlumneViewModelInsert : ViewModel() {

    fun newAlumn(context: Context, nom:String, grup:String, nota:Int) {

        var alumn = Alumne(nom, grup, nota)
        Repository.insertAlumne(context,alumn)
    }

    companion object {
        fun obtenirAlumnes(requireContext: Context): LiveData<List<Alumne>>? {
            return Repository.getAlumne(requireContext)
        }
    }
}