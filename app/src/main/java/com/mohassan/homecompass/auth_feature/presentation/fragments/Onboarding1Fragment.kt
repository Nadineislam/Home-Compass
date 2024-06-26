package com.mohassan.homecompass.auth_feature.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mohassan.homecompass.R
import com.mohassan.homecompass.databinding.FragmentOnboarding1Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Onboarding1Fragment : Fragment() {

    private lateinit var binding: FragmentOnboarding1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentOnboarding1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_onboarding1Fragment_to_onboarding2Fragment)
        }

        binding.btnSkip.setOnClickListener {
            findNavController().navigate(R.id.action_onboarding1Fragment_to_signUpOrSignInFragment)
        }
    }

}