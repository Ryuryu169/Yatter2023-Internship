package com.dmm.bootcamp.yatter2023.ui.updateuser

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun UpdateUserTemplate(
    userName: String,
    onChangedUserName: (String) -> Unit,
    displayName: String,
    onChangedDisplayName: (String) -> Unit,
    bio: String,
    onChangedBio: (String) -> Unit,
    onClickSaved: () -> Unit,
    onClickBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onClickBack) {
                        Icon(Icons.Default.ArrowBack, "Go back")
                    }
                },
                title = {
                    Text("アカウント編集画面")
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(20.dp)
        ) {
            Column() {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    text = "ユーザー名"
                )
                OutlinedTextField(
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    value = userName,
                    onValueChange = onChangedUserName,
                    placeholder = {
                        Text(text = "username")
                    },
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "表示名"
                )
                OutlinedTextField(
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    value = displayName,
                    onValueChange = onChangedDisplayName,
                    placeholder = {
                        Text(text = "password")
                    },
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "一言コメント"
                )
                OutlinedTextField(
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    value = bio,
                    onValueChange = onChangedBio,
                    placeholder = {
                        Text(text = "bio")
                    },
                )
                Spacer(Modifier.size(50.dp))
                Button(
                    enabled = true,
                    onClick = onClickSaved,
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Text(text = "アカウントの更新")
                }
            }
        }
    }
}

@Preview
@Composable
fun UpdateUserTemplatePreview() {
    UpdateUserTemplate(
        userName = "Kaname",
        onChangedUserName = {},
        displayName = "Kanamen",
        onChangedDisplayName = {},
        bio = "Nice to meet you",
        onChangedBio = {},
        onClickSaved = {},
        onClickBack = {},
    )
}