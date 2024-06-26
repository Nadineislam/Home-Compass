package com.mohassan.homecompass.auth_feature.presentation.fragments

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.mohassan.homecompass.R
import com.mohassan.homecompass.core.utils.Constants.SPLASH_SCREEN_DELAY
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_splash, container, false)

        lifecycleScope.launch {
            delay(SPLASH_SCREEN_DELAY)
            navigateToOnboardingFragment()
        }

        return view
    }
    private fun navigateToOnboardingFragment() {
        findNavController().navigate(R.id.action_splashFragment_to_onboarding1Fragment)
    }
}