package com.ruben.examenuf1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ruben.examenuf1.model.Alumne

class SharedViewModel : ViewModel() {

    private val _selectedItem = MutableLiveData<Alumne>()
    val selectedItem: LiveData<Alumne> get() = _selectedItem

    //Seleccionar item DB
    fun setSelectedItem(item: Alumne) {
        _selectedItem.value = item
    }
}