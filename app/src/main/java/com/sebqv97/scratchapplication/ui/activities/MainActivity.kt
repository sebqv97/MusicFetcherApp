package com.sebqv97.scratchapplication.ui.activities
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.sebqv97.scratchapplication.R
import com.sebqv97.scratchapplication.adapters.ViewPagerAdapter
import com.sebqv97.scratchapplication.databinding.ActivityMainBinding
import com.sebqv97.scratchapplication.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPager2.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            when (position) {
                0 -> tab.setText("Rock").setIcon(R.drawable.icons8_rock_50_2)

                1 ->  tab.setText("Classic").setIcon(R.drawable.icons8_classic_50)
                2 ->  tab.setText("Rock").setIcon(R.drawable.icons8_pop_50)
            }
        }.attach()
        setContentView(binding.root)
    }
}