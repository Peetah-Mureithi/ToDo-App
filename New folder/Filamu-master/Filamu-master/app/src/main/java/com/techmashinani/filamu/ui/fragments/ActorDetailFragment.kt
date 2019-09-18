package com.techmashinani.filamu.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import com.techmashinani.filamu.R
import com.techmashinani.filamu.di.Injectable
import com.techmashinani.filamu.utils.POSTER_URL
import com.techmashinani.filamu.viewmodels.ActorViewModel
import kotlinx.android.synthetic.main.fragment_actor_detail.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class ActorDetailFragment : Fragment(), Injectable {

    @Inject lateinit var mFactory: ViewModelProvider.Factory
    lateinit var viewModel: ActorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_actor_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, mFactory).get(ActorViewModel::class.java)
        val bundle = ActorDetailFragmentArgs.fromBundle(arguments!!)
        viewModel.init(bundle.actor)
        showData()
    }

    private fun showData() {
        viewModel.actorLiveData.observe(viewLifecycleOwner, Observer {
            // show actor details
            Glide.with(context!!)
                .load("$POSTER_URL${it.profile_path}")
                .placeholder(R.drawable.ic_movie)
                .apply(RequestOptions.centerInsideTransform())
                .centerCrop()
                .into(image_actor_detail)

            text_actor_name.text = it.name
        })

        viewModel.personLiveData.observe(viewLifecycleOwner, Observer {
            // show person details
        })
    }
}
