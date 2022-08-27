package com.ugg.movieapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ugg.movieapp.R
import com.ugg.movieapp.models.artists.ArtistResult
import com.ugg.movieapp.util.Resource

class ArtistsAdapter(private val artistList: List<ArtistResult>): RecyclerView.Adapter<ArtistsAdapter.ArtistsViewHolder>() {
    inner class ArtistsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val artistName: TextView = itemView.findViewById(R.id.artist_name)
        val artistImage: ImageView = itemView.findViewById(R.id.artist_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistsViewHolder {
        return ArtistsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.artists_list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ArtistsViewHolder, position: Int) {
        holder.artistName.text= artistList[position].name
    }

    override fun getItemCount(): Int {
        return artistList.size
    }
}