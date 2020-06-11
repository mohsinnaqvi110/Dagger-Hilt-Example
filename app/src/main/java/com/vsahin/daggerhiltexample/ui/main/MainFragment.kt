package com.vsahin.daggerhiltexample.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.vsahin.daggerhiltexample.R
import com.vsahin.daggerhiltexample.extension.exhaustive
import com.vsahin.daggerhiltexample.data.MyResult
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_fragment.*

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.numberList.observe(viewLifecycleOwner, Observer {
            when (it) {
                is MyResult.Success -> message.text = it.data.size.toString()
                is MyResult.Error -> message.text = getString(R.string.error)
                is MyResult.Loading -> message.text = getString(R.string.loading)
            }.exhaustive
        })
    }
}