package com.mohassan.homecompass.home_compass_feature.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mohassan.homecompass.databinding.FragmentChatbotBinding
import com.mohassan.homecompass.home_compass_feature.presentation.viewmodels.ChatBotViewModel

class ChatBotFragment : Fragment() {

    private var _binding: FragmentChatbotBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val chatBotViewModel =
            ViewModelProvider(this).get(ChatBotViewModel::class.java)

        _binding = FragmentChatbotBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        chatBotViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}