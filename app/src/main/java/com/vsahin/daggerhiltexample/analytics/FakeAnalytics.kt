package com.vsahin.daggerhiltexample.analytics

import android.util.Log
import javax.inject.Inject

class FakeAnalytics @Inject constructor() {
    fun sendScreen(screenName: String) {
        Log.d(TAG, "sendScreen: $screenName")
    }

    companion object {
        private const val TAG: String = "FakeAnalytics"
    }
}