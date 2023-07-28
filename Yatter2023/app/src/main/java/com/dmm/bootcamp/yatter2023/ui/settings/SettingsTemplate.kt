package com.dmm.bootcamp.yatter2023.ui.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SettingsTemplate(
    onClickReturn: () -> Unit,
    onClickAccount: () -> Unit,
    onClickFollower: () -> Unit,
    onClickSignOut: () -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("設定")
                },
                navigationIcon = {
                    IconButton(
                        onClick = onClickReturn,
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Go Back"
                        )
                    }
                }
            )
        }
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(8.dp),
            contentAlignment = Alignment.Center,
        ){
            EachSettings(
                onClickAccount = onClickAccount,
                onClickFollower = onClickFollower,
                onClickSignOut = onClickSignOut
            )
        }

    }
}

@Preview
@Composable
fun SettingsTemplateView(){
    SettingsTemplate(onClickAccount = {}, onClickFollower = {}, onClickSignOut = {}, onClickReturn = {})
}