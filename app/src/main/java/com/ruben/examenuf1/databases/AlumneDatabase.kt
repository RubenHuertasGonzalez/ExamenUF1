package com.ruben.examenuf1.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ruben.examenuf1.model.Alumne

@Database(
    entities = [Alumne::class],
    version = 1,
    exportSchema = false
)


abstract class AlumneDatabase  : RoomDatabase(){
    abstract fun AlumneDAO() : AlumneDAO

    companion object {

        @Volatile
        private var INSTANCE: AlumneDatabase? = null

        fun getDatabase(context: Context): AlumneDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            if (INSTANCE == null) {
                synchronized(this) {
                    // Pass the database to the INSTANCE
                    INSTANCE = buildDatabase(context)
                }
            }
            // Return database.
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): AlumneDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AlumneDatabase::class.java,
                "alumne_database"
            )
                .build()
        }
    }
}