package com.ugg.movieapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ugg.movieapp.R
import com.ugg.movieapp.models.Genre
import com.ugg.movieapp.models.GenresModel

class GenresAdapter(private val genresList: List<Genre>) : RecyclerView.Adapter <GenresAdapter.GenresViewHolder>() {

    inner class GenresViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.findViewById(R.id.genres_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresViewHolder {
        return GenresViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.genres_list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GenresViewHolder, position: Int) {
        holder.textView.text = genresList[position].name.toString()
    }

    override fun getItemCount(): Int {
        return genresList.size
    }
}