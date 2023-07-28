package com.dmm.bootcamp.yatter2023.ui.more

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MorePage(
    viewModel: MoreViewModel
){
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    MoreTemplate(
        statusBindingModel = uiState.status!!,
        isLoading = uiState.isLoading,
        onClickGoBack = viewModel::onClickGoBack
    )
}