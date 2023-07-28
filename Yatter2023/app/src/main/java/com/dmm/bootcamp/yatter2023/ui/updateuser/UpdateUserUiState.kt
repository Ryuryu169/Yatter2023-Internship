package com.dmm.bootcamp.yatter2023.ui.register

import com.dmm.bootcamp.yatter2023.ui.updateuser.UpdateUserBindingModel

data class UpdateUserUiState(
    val updateUserBindingModel: UpdateUserBindingModel,
    val isLoading: Boolean,
) {
    companion object {
        fun empty(): UpdateUserUiState = UpdateUserUiState(
            updateUserBindingModel = UpdateUserBindingModel(
                username = "",
                displayName = "",
                bio = "",
            ),
            isLoading = false,
        )
    }
}