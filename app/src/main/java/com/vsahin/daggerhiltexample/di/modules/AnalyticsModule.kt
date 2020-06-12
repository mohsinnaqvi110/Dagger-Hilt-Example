package com.vsahin.daggerhiltexample.di.modules

import com.vsahin.daggerhiltexample.analytics.AnotherFakeAnalytics
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object AnalyticsModule {
    @Provides
    fun provideAnotherFakeAnalytics() =
        AnotherFakeAnalytics()
}