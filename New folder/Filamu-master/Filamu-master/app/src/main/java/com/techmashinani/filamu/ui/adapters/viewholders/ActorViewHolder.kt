package com.techmashinani.filamu.ui.adapters.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.techmashinani.filamu.R
import com.techmashinani.filamu.model.Actor
import com.techmashinani.filamu.utils.POSTER_URL
import kotlinx.android.synthetic.main.item_actor.view.*

class ActorViewHolder(val view: View, private val listener: (Actor) -> Unit) : RecyclerView.ViewHolder(view) {

    fun bind(actor: Actor) {
       if(actor.profile_path != null) {
           Glide.with(view)
               .load("$POSTER_URL${actor.profile_path}")
               .placeholder(R.drawable.ic_movie)
               .apply(RequestOptions.centerInsideTransform())
               .centerCrop()
               .into(view.image_actor)
       }

        view.setOnClickListener { listener(actor) }
    }

    companion object {
        fun create(parent: ViewGroup, listener: (Actor) -> Unit): ActorViewHolder = ActorViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_actor, parent, false), listener)
    }
}