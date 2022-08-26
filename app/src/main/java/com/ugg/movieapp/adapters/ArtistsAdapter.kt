package com.ugg.movieapp.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ugg.movieapp.R
import com.ugg.movieapp.models.artists.ArtistResult

class ArtistsAdapter (private val artistsList: List<ArtistResult>): RecyclerView.Adapter<ArtistsAdapter.ArtistsViewHolder>() {
    inner class ArtistsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val artistName: TextView = itemView.findViewById(R.id.artist_name)
        val artistImage: ImageView = itemView.findViewById(R.id.artist_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistsViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ArtistsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}