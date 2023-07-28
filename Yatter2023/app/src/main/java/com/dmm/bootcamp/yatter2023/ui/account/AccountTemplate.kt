package com.dmm.bootcamp.yatter2023.ui.account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.dmm.bootcamp.yatter2023.domain.model.AccountId
import com.dmm.bootcamp.yatter2023.domain.model.Me
import com.dmm.bootcamp.yatter2023.domain.model.Username
import com.dmm.bootcamp.yatter2023.infra.domain.model.MeImpl
import com.dmm.bootcamp.yatter2023.ui.theme.Yatter2023Theme
import com.dmm.bootcamp.yatter2023.ui.timeline.bindingmodel.MediaBindingModel
import com.dmm.bootcamp.yatter2023.ui.timeline.bindingmodel.StatusBindingModel

@Composable
fun AccountTemplate(
    account: Me,
    isLoading: Boolean,
    onReturn: () -> Unit,
    onChangedClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = onReturn
                    ) {
                        Icon(Icons.Default.ArrowBack, "Return")
                    }
                },
                title = {
                    Text(text = "ユーザ画面")
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(40.dp),
            //contentAlignment = Alignment.Center,
        ) {
            Column(
                //horizontalAlignment = Alignment.End
            ) {
                Row() {
                    val imageModifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                    val textModifier = Modifier.padding(5.dp)
                    if (account.avatar.toString() != "null") {
                        AsyncImage(
                            modifier = imageModifier,
                            model = account.avatar,
                            contentDescription = "アバター画像",
                            contentScale = ContentScale.Crop,
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Icon",
                            modifier = imageModifier.background(Color.LightGray)
                        )
                    }
                    Spacer(Modifier.size(30.dp))
                    Box(Modifier.size(160.dp)) {
                        Column() {
                            Text(text = account.username.value, fontSize = 20.sp, modifier = textModifier)
                            Text(text = "@${account.displayName}", fontSize = 16.sp)
                            Spacer(Modifier.size(30.dp))
                            Text(text = "Followers ${account.followerCount}")
                            Text(text = "Following ${account.followingCount}")
                        }
                    }
                }
                Text(text = "${account.note}",/*modifier = Modifier.align(Alignment.CenterHorizontally)*/)
                Spacer(Modifier.size(40.dp))
                TextButton(
                    onClick = onChangedClick,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("編集", fontSize = 20.sp)
                }
                Spacer(Modifier.size(40.dp))
                Text("あなたのイート一覧",modifier = Modifier.align(Alignment.CenterHorizontally),fontSize = 20.sp, color= Color.Gray)
                Divider(modifier = Modifier.padding(vertical = 20.dp))
            }
            if(isLoading){
                CircularProgressIndicator()
            }
        }
    }
}

@Preview
@Composable
private fun AccountTemplatePreview() {
    Yatter2023Theme() {
        Surface {
            AccountTemplate(
                account = MeImpl(
                    id = AccountId("Hello"),
                    username = Username("name"),
                    displayName = "Hello",
                    note = "Nice to meet you",
                    avatar = null,
                    header = null,
                    followerCount = 0,
                    followingCount = 0

                ),
                onChangedClick = {},
                onReturn = {},
                isLoading = true
            )
        }
    }
}