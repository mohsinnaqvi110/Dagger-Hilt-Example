package com.vsahin.daggerhiltexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vsahin.daggerhiltexample.R
import com.vsahin.daggerhiltexample.ui.detail.DetailFragment
import com.vsahin.daggerhiltexample.ui.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()

            supportFragmentManager.beginTransaction()
                .replace(R.id.container2, DetailFragment.newInstance())
                .commitNow()
        }
    }
}