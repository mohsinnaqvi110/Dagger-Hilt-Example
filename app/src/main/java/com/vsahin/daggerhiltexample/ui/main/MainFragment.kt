package com.vsahin.daggerhiltexample.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.vsahin.daggerhiltexample.analytics.AnotherFakeAnalytics
import com.vsahin.daggerhiltexample.R
import com.vsahin.daggerhiltexample.extension.exhaustive
import com.vsahin.daggerhiltexample.data.MyResult
import com.vsahin.daggerhiltexample.ui.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject
import kotlin.random.Random

@AndroidEntryPoint
class MainFragment : Fragment() {

    @Inject
    lateinit var anotherFakeAnalytics: AnotherFakeAnalytics
    private val viewModel: MainViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Log.d(TAG, "AnotherFakeAnalytics: $anotherFakeAnalytics")

        swipeRefreshLayout.setOnRefreshListener {
            viewModel.refresh()
            anotherFakeAnalytics.sendRefresh()
        }

        randomNumber.setOnClickListener {
            sharedViewModel.randomNumber.postValue(Random.nextInt(10))
        }

        viewModel.numberList.observe(viewLifecycleOwner, Observer {
            when (it) {
                is MyResult.Success -> {
                    message.text = it.data.size.toString()
                    swipeRefreshLayout.isRefreshing = false
                }
                is MyResult.Error -> {
                    message.text = getString(R.string.error)
                    swipeRefreshLayout.isRefreshing = false
                }
                is MyResult.Loading -> {
                    message.text = getString(R.string.loading)
                    swipeRefreshLayout.isRefreshing = true
                }
            }.exhaustive
        })
    }

    companion object {
        private const val TAG: String = "MainFragment"

        fun newInstance() = MainFragment()
    }
}