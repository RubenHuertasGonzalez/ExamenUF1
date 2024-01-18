package com.ruben.examenuf1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ruben.examenuf1.R
import com.ruben.examenuf1.model.Alumne

class AlumneAdapter(private val alumne: List<Alumne>, private val onItemClick: (Alumne) -> Unit) :
    RecyclerView.Adapter<AlumneAdapter.alumneViewHolder>() {

    // ViewHolder que contiene las vistas para cada elemento
    class alumneViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val nom: TextView = view.findViewById(R.id.textViewNombre)
        val grup: TextView = view.findViewById(R.id.textViewGrupo)
        val nota: TextView = view.findViewById(R.id.textViewNota)
    }

    // Crea una nueva vista (invocada por el layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): alumneViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cardview, parent, false) // Usa tu CardView aquí
        return alumneViewHolder(view)
    }

    // Reemplaza el contenido de una vista (invocada por el layout manager)
    override fun onBindViewHolder(holder: alumneViewHolder, position: Int) {
        val alumnes = alumne[position]

        holder.itemView.setOnClickListener {
            onItemClick.invoke(alumnes)
        }

        holder.nom.text = alumnes.name
        holder.grup.text = alumnes.group
        holder.nota.text = alumnes.note.toString()
    }

    // Devuelve el tamaño de tu conjunto de datos (invocada por el layout manager)
    override fun getItemCount() = alumne.size
}