package com.mohassan.homecompass.home_compass_feature.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.mohassan.homecompass.databinding.FragmentHomeBinding
import com.mohassan.homecompass.home_compass_feature.presentation.adapters.ViewPagerAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.viewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when(position){
                0 -> tab.text = "Feed"
                1 -> tab.text = "Jobs"
                2 -> tab.text = "Shelters"
                else -> tab.text = "Food"
            }
        }.attach()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}