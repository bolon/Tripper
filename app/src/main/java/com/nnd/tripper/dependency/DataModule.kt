package com.nnd.tripper.dependency

import android.content.Context
import dagger.Module
import org.jetbrains.anko.AnkoLogger

/**
 * Created by Android dev on 8/4/17.
 */
@Module
class DataModule constructor(val context: Context) : AnkoLogger