package com.nnd.tripper

import android.app.Application
import android.content.Context
import com.nnd.tripper.dependency.ApplicationComponent
import com.nnd.tripper.dependency.DaggerApplicationComponent
import com.nnd.tripper.dependency.DataModule
import com.nnd.tripper.dependency.NetworkModule

/**
 * Created by Android dev on 8/3/17.
 */

class BaseApp : Application() {
    companion object ComponentFactory {
        private var component: ApplicationComponent? = null
        private fun createComponent(context: Context) {
            component = DaggerApplicationComponent.builder()
                    .networkModule(NetworkModule())
                    .dataModule(DataModule())
                    .build()
        }

        fun getComponent(context: Context): ApplicationComponent? {
            if (component == null) createComponent(context)

            return component
        }
    }

    override fun onCreate() {
        super.onCreate()
        //stub
    }
}
