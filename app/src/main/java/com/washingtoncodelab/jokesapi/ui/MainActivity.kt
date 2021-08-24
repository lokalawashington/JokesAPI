package com.washingtoncodelab.jokesapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.washingtoncodelab.jokesapi.adpters.JokesAdapter
import com.washingtoncodelab.jokesapi.databinding.ActivityMainBinding
import com.washingtoncodelab.jokesapi.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy {
        JokesAdapter()
    }
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel._reult.observe(this, Observer {
            adapter.submitList(it)
            binding.recyclerView.adapter = adapter
        })

    }
}