package com.dmm.bootcamp.yatter2023.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dmm.bootcamp.yatter2023.R
import com.dmm.bootcamp.yatter2023.ui.theme.Yatter2023Theme

@Composable
fun LoginTemplate(
    userName: String,
    onChangedUserName: (String) -> Unit,
    password: String,
    onChangedPassword: (String) -> Unit,
    isEnableLogin: Boolean,
    isLoading: Boolean,
    onClickLogin: () -> Unit,
    onClickRegister: () -> Unit,
) {
    Scaffold(
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(40.dp),
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                /*Text(
                    text = "Yatter",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(40.dp),
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 50.sp
                )*/
                Image(
                    painter = painterResource(R.drawable.y),
                    contentDescription = "Main page",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(40.dp),
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    //.padding(.dp),
                    text = "ユーザー名"
                )
                OutlinedTextField(
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 30.dp),
                    value = userName,
                    onValueChange = onChangedUserName,
                    placeholder = {
                        Text(text = "username")
                    },
                    leadingIcon = {
                        Icon(
                            Icons.Default.Email,
                            "Email",
                            modifier = Modifier.padding(horizontal = 20.dp)
                        )
                    }
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "パスワード"
                )
                OutlinedTextField(
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 30.dp),
                    value = password,
                    onValueChange = onChangedPassword,
                    placeholder = {
                        Text(text = "password")
                    },
                    leadingIcon = {
                        Icon(
                            Icons.Default.Lock,
                            "Password",
                            modifier = Modifier.padding(horizontal = 20.dp)
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                    ),

                    )
                Button(
                    enabled = isEnableLogin,
                    shape = CircleShape,
                    onClick = onClickLogin,
                    modifier = Modifier
                        .padding(0.dp, 0.dp)
                        .fillMaxWidth(),
                ) {
                    Text(text = "ログイン")
                }

                Divider(modifier = Modifier.padding(top = 40.dp, bottom = 20.dp))

                Text(
                    text = "はじめてご利用の方は",
                    color = Color.Gray,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.body2
                )
                TextButton(
                    onClick = onClickRegister,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "新規会員登録",fontSize = 15.sp,modifier = Modifier.padding(20.dp))
                }
                if (isLoading) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}

@Preview
@Composable
fun LoginTemplatePreview() {
    Yatter2023Theme {
        Surface {
            LoginTemplate(
                userName = "username",
                onChangedUserName = {},
                password = "password",
                onChangedPassword = {},
                isEnableLogin = true,
                isLoading = false,
                onClickLogin = {},
                onClickRegister = {},
            )
        }
    }
}