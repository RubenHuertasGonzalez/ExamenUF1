package com.ruben.examenuf1.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.ruben.examenuf1.databases.AlumneDatabase
import com.ruben.examenuf1.model.Alumne
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository {

    companion object {

        var alumneDatabase: AlumneDatabase? = null

        var alumne: LiveData<List<Alumne>>? = null


        fun initializeDB(context: Context): AlumneDatabase {
            return AlumneDatabase.getDatabase(context)
        }

        //INSERT alumne
        fun insertAlumne(context: Context, alumne: Alumne) {

            alumneDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                alumneDatabase!!.AlumneDAO().addAlumne(alumne)
            }
        }

        //SELECT* alumnes
        fun getAlumne(context: Context): LiveData<List<Alumne>>? {

            alumneDatabase = initializeDB(context)

            alumne = alumneDatabase!!.AlumneDAO().getAlumn()

            return alumne
        }

        fun getAprobados(context: Context, notaApro: Int): LiveData<List<Alumne>>? {
            alumneDatabase = initializeDB(context)

            return alumneDatabase!!.AlumneDAO().getAprobados(notaApro)
        }

        fun getSuspendidos(context: Context, notaSus: Int): LiveData<List<Alumne>>? {
            alumneDatabase = initializeDB(context)

            return alumneDatabase!!.AlumneDAO().getSuspendidos(notaSus)
        }
    }
}