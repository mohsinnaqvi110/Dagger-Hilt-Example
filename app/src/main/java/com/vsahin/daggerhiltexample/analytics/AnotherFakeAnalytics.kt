package com.vsahin.daggerhiltexample.analytics

import android.util.Log
import javax.inject.Inject

class AnotherFakeAnalytics @Inject constructor() {
    fun sendRefresh() {
        Log.d(TAG, "sendRefresh")
    }

    companion object {
        private const val TAG: String = "AnotherFakeAnalytics"
    }
}