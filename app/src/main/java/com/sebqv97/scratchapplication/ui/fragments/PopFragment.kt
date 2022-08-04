package com.sebqv97.scratchapplication.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
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
class PopFragment : Fragment(R.layout.fragment_songs) {
    val mainViewModel: MainViewModel by lazy { ViewModelProvider(this@PopFragment).get(MainViewModel::class.java) }
   lateinit var binding: FragmentSongsBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding =FragmentSongsBinding.bind(view)
        //calling repository getSongs Api with term "pop"
        mainViewModel.getSongs(ApiReference.POP)

        mainViewModel.musicDetails.observe(viewLifecycleOwner){
            when(it){
                is UiState.Loading -> {
                    Log.d("Api Response", "Loading")
                }
                is UiState.Success -> binding.recyclerViewSongs.apply {
                    background = AppCompatResources.getDrawable(context,R.color.pop_bg_color)
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = SongsAdapter(it.musicResponse.results)

                }
                is UiState.Failure -> throw Exception(it.error.message)
            }

        }

    }
}