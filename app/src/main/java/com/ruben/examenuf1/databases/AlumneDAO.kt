package com.ruben.examenuf1.databases

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ruben.examenuf1.model.Alumne

@Dao
interface AlumneDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAlumne(alumne: Alumne)

    @Query("SELECT * FROM alumn")
    fun getAlumn(): LiveData<List<Alumne>>

    @Query("SELECT * FROM alumn WHERE note =:notaApro >=5")
    fun getAprobados(notaApro:Int): LiveData<List<Alumne>>

    @Query("SELECT * FROM alumn WHERE note =:notaSus < 5")
    fun getSuspendidos(notaSus:Int): LiveData<List<Alumne>>

}