package com.vsahin.daggerhiltexample.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.vsahin.daggerhiltexample.R
import com.vsahin.daggerhiltexample.analytics.AnotherFakeAnalytics
import com.vsahin.daggerhiltexample.data.MyResult
import com.vsahin.daggerhiltexample.extension.exhaustive
import com.vsahin.daggerhiltexample.ui.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.detail_fragment.*
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment : Fragment() {
    @Inject
    lateinit var anotherFakeAnalytics: AnotherFakeAnalytics
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Log.d(TAG, "AnotherFakeAnalytics: $anotherFakeAnalytics")

        viewModel.setId(5)
        viewModel.number.observe(viewLifecycleOwner, Observer {
            when (it) {
                is MyResult.Success -> text.text = it.data.toString()
                is MyResult.Error -> text.text = getString(R.string.error)
                is MyResult.Loading -> text.text = getString(R.string.loading)
            }.exhaustive
        })
    }

    companion object {
        private const val TAG: String = "DetailFragment"

        fun newInstance() = DetailFragment()
    }
}