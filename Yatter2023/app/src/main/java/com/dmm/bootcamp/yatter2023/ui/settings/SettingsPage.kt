package com.dmm.bootcamp.yatter2023.ui.settings

import androidx.compose.runtime.Composable

@Composable
fun SettingsPage(viewModel: SettingsViewModel){
    SettingsTemplate(
        onClickReturn = viewModel::onClickReturn,
        onClickAccount = viewModel::onClickAccount,
        onClickFollower = viewModel::onClickFollower,
        onClickSignOut = viewModel::onClickSignOut
    )
}