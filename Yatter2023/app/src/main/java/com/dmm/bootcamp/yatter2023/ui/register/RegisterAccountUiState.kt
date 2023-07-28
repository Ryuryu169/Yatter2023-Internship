package com.dmm.bootcamp.yatter2023.ui.register

data class RegisterAccountUiState(
    val registerBindingModel: RegisterAccountBindingModel,
    val isLoading: Boolean,
    val validUsername: Boolean,
    val validPassword: Boolean,
) {
    val isEnableRegister: Boolean = validUsername && validPassword
    companion object {
        fun empty(): RegisterAccountUiState = RegisterAccountUiState(
            registerBindingModel = RegisterAccountBindingModel(
                username = "",
                password = ""
            ),
            validUsername = false,
            validPassword = false,
            isLoading = false,
        )
    }
}