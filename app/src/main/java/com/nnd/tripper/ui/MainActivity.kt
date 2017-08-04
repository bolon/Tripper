package com.nnd.tripper.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nnd.tripper.R
import com.nnd.tripper.model.Receipt
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.wtf
import java.util.*

class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text_view.text = resources.getText(R.string.app_name)
        wtf("o hell o")

        val r: Receipt = Receipt(1, "test1", "test2", Collections.emptyList())
        info(r.total)
    }
}
