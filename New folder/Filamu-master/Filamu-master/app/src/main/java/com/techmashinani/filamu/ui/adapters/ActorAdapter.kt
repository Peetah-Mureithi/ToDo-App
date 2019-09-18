package com.techmashinani.filamu.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.techmashinani.filamu.model.Actor
import com.techmashinani.filamu.ui.adapters.viewholders.ActorViewHolder

class ActorAdapter(private val listener: (Actor) -> Unit) : ListAdapter<Actor, ActorViewHolder>(
    object: DiffUtil.ItemCallback<Actor>() {
        override fun areItemsTheSame(oldItem: Actor, newItem: Actor): Boolean = oldItem.profile_path == newItem.profile_path
        override fun areContentsTheSame(oldItem: Actor, newItem: Actor): Boolean = oldItem == newItem
    }
) {
    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder = ActorViewHolder.create(parent, listener)
}