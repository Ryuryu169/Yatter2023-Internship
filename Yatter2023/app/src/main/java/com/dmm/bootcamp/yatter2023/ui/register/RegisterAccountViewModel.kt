package com.dmm.bootcamp.yatter2023.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmm.bootcamp.yatter2023.domain.model.Password
import com.dmm.bootcamp.yatter2023.domain.model.Username
import com.dmm.bootcamp.yatter2023.usecase.register.RegisterAccountUseCase
import com.dmm.bootcamp.yatter2023.usecase.register.RegisterAccountUseCaseResult
import com.dmm.bootcamp.yatter2023.util.SingleLiveEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegisterAccountViewModel(
    private val registerUseCase: RegisterAccountUseCase,
) : ViewModel() {
    private val _uiState: MutableStateFlow<RegisterAccountUiState> = MutableStateFlow(RegisterAccountUiState.empty())
    val uiState: StateFlow<RegisterAccountUiState> = _uiState
    private val _navigateToPublicTimeline: SingleLiveEvent<Unit> = SingleLiveEvent()
    val navigateToPublicTimeline: LiveData<Unit> = _navigateToPublicTimeline
    private val _navigateToLogin: SingleLiveEvent<Unit> = SingleLiveEvent()
    val navigateToLogin: LiveData<Unit> = _navigateToLogin

    fun onChangedUsername(username: String) {
        val snapshotBindingModel = uiState.value.registerBindingModel
        _uiState.update {
            it.copy(
                validUsername = Username(username).validate(),
                registerBindingModel = snapshotBindingModel.copy(
                    username = username
                )
            )
        }
    }

    fun onChangedPassword(password: String) {
        val snapshotBindingModel = uiState.value.registerBindingModel
        _uiState.update {
            it.copy(
                validPassword = Password(password).validate(),
                registerBindingModel = snapshotBindingModel.copy(
                    password = password
                )
            )
        }
    }

    fun onClickRegister(){
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) } // 1

            val snapBindingModel = uiState.value.registerBindingModel
            when (
                val result =
                    registerUseCase.execute(
                        snapBindingModel.username,
                        snapBindingModel.password,
                    )
            ) {
                is RegisterAccountUseCaseResult.Success -> {
                    _navigateToPublicTimeline.value = Unit

                }

                is RegisterAccountUseCaseResult.Failure -> {

                }
            }

            _uiState.update { it.copy(isLoading = true) }
        }
    }

    fun onClickLogin(){
        _navigateToLogin.value = Unit
    }
}