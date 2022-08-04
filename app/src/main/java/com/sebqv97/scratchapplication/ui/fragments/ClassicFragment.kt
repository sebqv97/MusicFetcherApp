package com.sebqv97.scratchapplication.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sebqv97.scratchapplication.R
import com.sebqv97.scratchapplication.adapters.SongsAdapter
import com.sebqv97.scratchapplication.data.ApiReference
import com.sebqv97.scratchapplication.databinding.FragmentSongsBinding
import com.sebqv97.scratchapplication.ui.MainViewModel
import com.sebqv97.scratchapplication.util.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClassicFragment : Fragment(R.layout.fragment_songs) {
    private lateinit var binding: FragmentSongsBinding
    val mainViewModel: MainViewModel by lazy { ViewModelProvider(this@ClassicFragment).get(MainViewModel::class.java) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSongsBinding.bind(view)
        //call viewModel getSongs Api with term "classic"
        mainViewModel.getSongs(ApiReference.CLASSIC)

        //observe the change of data

        mainViewModel.musicDetails.observe(viewLifecycleOwner){
            when(it){
                is UiState.Loading -> {
                    Log.d("Api Response", "Loading")
                }
                is UiState.Success -> binding.recyclerViewSongs.apply {
                    background = AppCompatResources.getDrawable(context,
                        R.color.classic_bg_color
                    )
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = SongsAdapter(it.musicResponse.results)

                }
                is UiState.Failure -> throw Exception(it.error.message)
            }
        }

    }
}