package com.sebqv97.scratchapplication.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sebqv97.scratchapplication.ui.fragments.ClassicFragment
import com.sebqv97.scratchapplication.ui.fragments.PopFragment
import com.sebqv97.scratchapplication.ui.fragments.RockFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    private val tabCounts = 3
    override fun getItemCount() = tabCounts

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> RockFragment()
            1 -> ClassicFragment()
            else -> PopFragment()
        }
}


