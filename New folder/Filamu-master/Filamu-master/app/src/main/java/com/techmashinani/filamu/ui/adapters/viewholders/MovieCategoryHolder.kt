package com.techmashinani.filamu.ui.adapters.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.techmashinani.filamu.R
import com.techmashinani.filamu.model.Movie
import com.techmashinani.filamu.model.MovieCategory
import com.techmashinani.filamu.ui.adapters.LatestMoviesAdapter
import kotlinx.android.synthetic.main.item_movie_category.view.*
import kotlinx.android.synthetic.main.main_fragment.view.*

class MovieCategoryHolder(private val view: View ) : RecyclerView.ViewHolder(view) {

    fun bind(adapter: LatestMoviesAdapter, category: MovieCategory, owner: LifecycleOwner) {
        view.text_category_title.text = category.category
        view.recycler_category_movies.apply {
            this.adapter = adapter
            this.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        }

        category.movies.observe(owner, Observer {
            adapter.submitList(it)
        })
    }

    companion object {
        fun create(parent: ViewGroup) =
            MovieCategoryHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie_category, parent, false))
    }
}