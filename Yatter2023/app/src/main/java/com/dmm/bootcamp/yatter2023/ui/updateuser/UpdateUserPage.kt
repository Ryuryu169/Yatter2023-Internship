package com.dmm.bootcamp.yatter2023.ui.updateuser

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dmm.bootcamp.yatter2023.ui.register.RegisterAccountUiState
import com.dmm.bootcamp.yatter2023.ui.register.UpdateUserUiState

@Composable
fun UpdateUserPage(viewModel: UpdateUserViewModel){
    val uiState: UpdateUserUiState by viewModel.uiState.collectAsStateWithLifecycle()
    UpdateUserTemplate(
        userName = uiState.updateUserBindingModel.username!!,
        onChangedUserName = viewModel::onChangedUsername,
        displayName = uiState.updateUserBindingModel.displayName!!,
        onChangedDisplayName = viewModel::onChangedDisplayName,
        bio = uiState.updateUserBindingModel.bio!!,
        onChangedBio = viewModel::onChangedBio,
        onClickSaved = viewModel::onClickedSaved,
        onClickBack = viewModel::onClickedBack
    )
}