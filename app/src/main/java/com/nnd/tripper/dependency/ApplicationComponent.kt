package com.nnd.tripper.dependency

import com.nnd.tripper.presenter.MainActivity
import com.nnd.tripper.presenter.SplashScreenActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Android dev on 8/4/17.
 */
@Singleton
@Component(modules = arrayOf(DataModule::class, NetworkModule::class))
interface ApplicationComponent {
    fun inject(a: MainActivity)
    fun inject(s: SplashScreenActivity)
}