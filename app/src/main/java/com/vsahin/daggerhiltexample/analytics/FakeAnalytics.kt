package com.vsahin.daggerhiltexample.analytics

import android.util.Log
import javax.inject.Inject

class FakeAnalytics @Inject constructor() {
    fun sendScreen(screenName: String) {
        Log.d(TAG, "sendScreen: $screenName")
    }

    fun sendView(viewName: String) {
        Log.d(TAG, "sendView: $viewName")
    }

    companion object {
        private const val TAG: String = "FakeAnalytics"
    }
}