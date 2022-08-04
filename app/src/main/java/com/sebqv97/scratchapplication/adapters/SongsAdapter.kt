package com.sebqv97.scratchapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sebqv97.scratchapplication.R
import com.sebqv97.scratchapplication.databinding.LayoutSongBinding
import com.sebqv97.scratchapplication.model.ResultModel
import com.squareup.picasso.Picasso

class SongsAdapter(private val mList: List<ResultModel>) :
    RecyclerView.Adapter<SongsAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder = MyViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.layout_song, parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {

            textViewArtistName.text =
                mList[position].artistName
            textViewAlbumPrice.text =
                mList[position].trackPrice.toString() + "USD"
            textViewCollectionName.text =
                mList[position].collectionName
            Picasso.get().load(mList[position].artworkUrl60).into(imageViewSong)

        }

    }

    override fun getItemCount() = mList.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = LayoutSongBinding.bind(itemView)

    }

}