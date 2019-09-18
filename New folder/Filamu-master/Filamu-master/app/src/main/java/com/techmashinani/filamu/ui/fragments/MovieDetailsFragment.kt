package com.techmashinani.filamu.ui.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.techmashinani.filamu.model.Movie
import com.techmashinani.filamu.utils.POSTER_URL_BIG
import kotlinx.android.synthetic.main.fragment_movie_details.*
import android.view.WindowManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.techmashinani.filamu.R
import com.techmashinani.filamu.di.Injectable
import com.techmashinani.filamu.model.Actor
import com.techmashinani.filamu.ui.activities.MainActivity
import com.techmashinani.filamu.ui.adapters.ActorAdapter
import com.techmashinani.filamu.viewmodels.MovieDetailViewModel
import timber.log.Timber
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class MovieDetailsFragment : Fragment(), Injectable {

    @Inject lateinit var mFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MovieDetailViewModel

    private val actorAdapter: ActorAdapter by lazy { ActorAdapter {actor -> showPersonDetails(actor)} }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val w = (activity as MainActivity).window
        w.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        recycler_actors.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = actorAdapter
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = MovieDetailsFragmentArgs.fromBundle(arguments!!)
        viewModel = ViewModelProviders.of(this, mFactory).get(MovieDetailViewModel::class.java)
        viewModel.init(bundle.movie)
        showDetails()
    }

    private fun showDetails() {
        viewModel.simpleMovie.observe(this, Observer {
            text_movie_desc.text = it.overview
            text_movie_name.text = it.title

            Glide.with(context!!)
                .load("$POSTER_URL_BIG${it.poster_path}")
                .placeholder(R.drawable.ic_movie)
                .centerCrop()
                .into(image_poster)
        })

        viewModel.movieLiveData.observe(this, Observer {
            // get actors
            actorAdapter.submitList(it.cast)
        })
    }

    private fun showPersonDetails(actor: Actor) {
        val action = MovieDetailsFragmentDirections.actionMovieDetailsFragmentToActorDetailFragment(actor)
        findNavController().navigate(action)
    }
}
