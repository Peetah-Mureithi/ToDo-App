package com.techmashinani.filamu.di

import com.techmashinani.filamu.ui.activities.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(FragmentBuilderModule::class)])
    abstract fun contributesMainActivity(): MainActivity
}