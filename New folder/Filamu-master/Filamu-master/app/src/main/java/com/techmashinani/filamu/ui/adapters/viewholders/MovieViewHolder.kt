package com.techmashinani.filamu.ui.adapters.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.techmashinani.filamu.R
import com.techmashinani.filamu.model.Movie
import com.techmashinani.filamu.utils.POSTER_URL
import kotlinx.android.synthetic.main.item_movie.view.*
import timber.log.Timber

class MovieViewHolder private constructor(private val view: View, private val listener: (Movie) -> Unit) : RecyclerView.ViewHolder(view) {

    fun initView(movie: Movie) {
        Timber.e("Movie ${movie.overview}")
        view.setOnClickListener { listener(movie) }

        Glide.with(view)
            .load("$POSTER_URL${movie.poster_path}")
            .placeholder(R.drawable.ic_movie)
            .centerCrop()
            .into(view.image_movie)
    }


    companion object {
        @JvmStatic fun create(parent: ViewGroup, resource: Int, listener: (Movie) -> Unit): MovieViewHolder =
            MovieViewHolder(LayoutInflater.from(parent.context).inflate(resource,parent, false), listener)
    }
}