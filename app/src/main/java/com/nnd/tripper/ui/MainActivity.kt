package com.nnd.tripper.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nnd.tripper.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.wtf

class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text_view.text = resources.getText(R.string.app_name)
        wtf("o hell o")
    }
}
