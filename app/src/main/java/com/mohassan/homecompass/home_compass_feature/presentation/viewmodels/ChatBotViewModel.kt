package com.mohassan.homecompass.home_compass_feature.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChatBotViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is ChatBot Fragment"
    }
    val text: LiveData<String> = _text
}