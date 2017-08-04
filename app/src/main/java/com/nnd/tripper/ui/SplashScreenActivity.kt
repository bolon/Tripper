package com.nnd.tripper.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nnd.tripper.BaseApp
import com.nnd.tripper.R
import com.nnd.tripper.model.RESTInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import retrofit2.HttpException
import javax.inject.Inject

class SplashScreenActivity : AppCompatActivity(), AnkoLogger {
    @Inject
    lateinit var restAPI: RESTInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        BaseApp.getComponent(applicationContext)!!.inject(SplashScreenActivity@ this)
        restAPI.checkStatus().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { obj -> info("yow its working" + obj.data) },
                        { t ->
                            if (t is HttpException)
                                info("Resp code : " + t.code())
                            else
                                t.printStackTrace()
                        },
                        {
                            info("done")
                            startActivity(Intent(applicationContext, MainActivity::class.java))
                        })
    }
}
