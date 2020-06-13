package com.vsahin.daggerhiltexample.ui.custom

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.vsahin.daggerhiltexample.analytics.FakeAnalytics
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MyTextView : AppCompatTextView {

    @Inject lateinit var fakeAnalytics: FakeAnalytics

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        fakeAnalytics.sendView(MyTextView::class.toString())
    }

}