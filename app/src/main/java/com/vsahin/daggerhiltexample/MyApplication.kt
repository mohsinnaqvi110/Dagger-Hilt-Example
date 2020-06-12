package com.vsahin.daggerhiltexample

import android.app.Activity
import android.os.Bundle
import androidx.multidex.MultiDexApplication
import com.vsahin.daggerhiltexample.analytics.FakeAnalytics
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication : MultiDexApplication() {
    @Inject
    lateinit var fakeAnalytics: FakeAnalytics

    override fun onCreate() {
        super.onCreate()
        this.registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity) {}

            override fun onActivityStarted(activity: Activity) {
                fakeAnalytics.sendScreen(activity.localClassName)
            }

            override fun onActivityDestroyed(activity: Activity) {}

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}

            override fun onActivityStopped(activity: Activity) {}

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}

            override fun onActivityResumed(activity: Activity) {}
        })
    }
}