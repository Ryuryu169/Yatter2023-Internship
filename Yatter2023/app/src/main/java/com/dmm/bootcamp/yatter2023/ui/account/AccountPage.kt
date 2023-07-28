package com.dmm.bootcamp.yatter2023.ui.account

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dmm.bootcamp.yatter2023.ui.account.AccountTemplate

@Composable
fun AccountPage(viewModel: AccountViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    AccountTemplate(
        account = uiState.myself,
        isLoading = uiState.isLoading,
        onReturn = viewModel::onReturn,
        onChangedClick = viewModel::onChangedClick,
    )
}