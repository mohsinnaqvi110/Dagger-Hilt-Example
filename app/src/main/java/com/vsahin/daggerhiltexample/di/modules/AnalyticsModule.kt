package com.vsahin.daggerhiltexample.di.modules

import com.vsahin.daggerhiltexample.AnotherFakeAnalytics
import com.vsahin.daggerhiltexample.FakeAnalytics
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object AnalyticsModule {
    @Provides
    fun provideAnotherFakeAnalytics() = AnotherFakeAnalytics()
}