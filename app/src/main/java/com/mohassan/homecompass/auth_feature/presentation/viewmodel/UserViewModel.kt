package com.mohassan.homecompass.auth_feature.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohassan.homecompass.auth_feature.domain.use_case.LoginUseCase
import com.mohassan.homecompass.auth_feature.domain.use_case.RegisterUseCase
import com.mohassan.homecompass.core.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    private val _registrationState = MutableSharedFlow<Resource<Unit>>()
    val registrationState: SharedFlow<Resource<Unit>> = _registrationState

    private val _loginState = MutableSharedFlow<Resource<Unit>>()
    val loginState: SharedFlow<Resource<Unit>> = _loginState

    fun registerUser(
        firstName: String,
        lastName: String,
        username: String,
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            _registrationState.emit(Resource.Loading())
            val result = registerUseCase(firstName, lastName, username, email, password)
            _registrationState.emit(result)
        }
    }

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            _loginState.emit(Resource.Loading())
            val result = loginUseCase(email, password)
            _loginState.emit(result)
        }
    }
}