package com.techmashinani.filamu.ui.adapters

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.techmashinani.filamu.model.Movie
import com.techmashinani.filamu.model.MovieCategory
import com.techmashinani.filamu.ui.adapters.viewholders.MovieCategoryHolder

class MovieCategoryAdapter(private val owner: LifecycleOwner, private val listener: (Movie) -> Unit)
    : ListAdapter<MovieCategory, MovieCategoryHolder>(
    object: DiffUtil.ItemCallback<MovieCategory>() {
        override fun areItemsTheSame(oldItem: MovieCategory, newItem: MovieCategory): Boolean = oldItem.category == newItem.category
        override fun areContentsTheSame(oldItem: MovieCategory, newItem: MovieCategory): Boolean = oldItem == newItem
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCategoryHolder = MovieCategoryHolder.create(parent)
    override fun onBindViewHolder(holder: MovieCategoryHolder, position: Int) {
        val adapter =  LatestMoviesAdapter(listener)
        holder.bind(adapter, getItem(position), owner)
    }
}