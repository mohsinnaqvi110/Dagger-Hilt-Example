package com.vsahin.daggerhiltexample.di.modules

import com.vsahin.daggerhiltexample.analytics.AnotherFakeAnalytics
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object AnalyticsModule {
    @ActivityScoped
    @Provides
    fun provideAnotherFakeAnalytics() =
        AnotherFakeAnalytics()
}