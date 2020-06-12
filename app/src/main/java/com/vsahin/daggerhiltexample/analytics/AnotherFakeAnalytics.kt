package com.vsahin.daggerhiltexample.analytics

import android.util.Log
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

class AnotherFakeAnalytics {
    fun sendRefresh() {
        Log.d(TAG, "sendRefresh")
    }

    companion object {
        private const val TAG: String = "AnotherFakeAnalytics"
    }
}