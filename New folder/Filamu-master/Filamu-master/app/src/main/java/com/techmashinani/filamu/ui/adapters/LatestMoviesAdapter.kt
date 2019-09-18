package com.techmashinani.filamu.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.techmashinani.filamu.R
import com.techmashinani.filamu.model.Movie
import com.techmashinani.filamu.ui.adapters.viewholders.MovieViewHolder

class LatestMoviesAdapter(private val listener: (Movie) -> Unit) : ListAdapter<Movie, MovieViewHolder>(
    object : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean = oldItem == newItem
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder = MovieViewHolder.create(parent, R.layout.item_movie, listener)
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.initView(getItem(position))
    }
}