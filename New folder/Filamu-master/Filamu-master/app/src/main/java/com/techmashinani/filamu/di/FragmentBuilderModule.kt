package com.techmashinani.filamu.di

import com.techmashinani.filamu.ui.fragments.ActorDetailFragment
import com.techmashinani.filamu.ui.fragments.MainFragment
import com.techmashinani.filamu.ui.fragments.MovieDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun bindDashFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun bindMovieDetailsFragment(): MovieDetailsFragment

    @ContributesAndroidInjector
    abstract fun bindPersonDetailFragment(): ActorDetailFragment
}
