package com.ruben.examenuf1.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ruben.examenuf1.model.Alumne
import com.ruben.examenuf1.repository.Repository

class GrupViewModelSelect : ViewModel() {

    var aprobats: LiveData<List<Alumne>>? = null

    //select grup
    fun obtenirAlumnes(context: Context): LiveData<List<Alumne>>? {
        return Repository.getAlumne(context)
    }

    fun obtenirAlumnesAprobats(context: Context, notaApro: Int): LiveData<List<Alumne>>? {
        aprobats = Repository.getAprobados(context, notaApro)
        return aprobats
    }

    fun obtenirAlumnesSuspendidos(context: Context, notaSus: Int): LiveData<List<Alumne>>? {
        aprobats = Repository.getSuspendidos(context, notaSus)
        return aprobats
    }
}