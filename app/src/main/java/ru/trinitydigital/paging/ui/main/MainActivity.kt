package ru.trinitydigital.paging.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.trinitydigital.paging.R

class MainActivity : AppCompatActivity() {

    private val vm by viewModel<MainViewModel>()

    private val adapter by lazy { NewsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView.adapter = adapter
        vm.data.observe(this, {
            adapter.submitList(it)
        })
    }
}