package com.dmm.bootcamp.yatter2023.ui.more

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
import com.dmm.bootcamp.yatter2023.domain.model.Me
import com.dmm.bootcamp.yatter2023.ui.theme.Yatter2023Theme
import com.dmm.bootcamp.yatter2023.ui.timeline.bindingmodel.MediaBindingModel
import com.dmm.bootcamp.yatter2023.ui.timeline.bindingmodel.StatusBindingModel

@Composable
fun MoreTemplate(
    statusBindingModel: StatusBindingModel,
    onClickGoBack: () -> Unit,
    isLoading: Boolean
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onClickGoBack) {
                        Icon(Icons.Default.ArrowBack, "Go Back")
                    }
                },
                title = {
                    Text("Yeet 詳細")
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .padding(40.dp)
                .fillMaxSize()
        ) {
            Column() {
                Row() {
                    val imageModifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                    val textModifier = Modifier.padding(5.dp)
                    if (statusBindingModel.avatar.toString() != "null") {
                        AsyncImage(
                            modifier = imageModifier,
                            model = statusBindingModel.avatar,
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
                    Box(Modifier.size(200.dp,100.dp)) {
                        Column() {
                            Spacer(Modifier.size(20.dp))
                            Text(
                                text = statusBindingModel.username,
                                fontSize = 20.sp,
                                modifier = textModifier
                            )
                            Text(text = "@${statusBindingModel.displayName}", fontSize = 16.sp)
                        }
                    }
                }
                Spacer(modifier = Modifier.size(30.dp))
                Text(statusBindingModel.content, modifier = Modifier.padding(20.dp), fontSize = 20.sp)
                Spacer(modifier = Modifier.size(40.dp))
                Text("コメント一覧",modifier = Modifier.align(Alignment.CenterHorizontally),fontSize = 20.sp, color= Color.Gray)
                Divider(modifier = Modifier.padding(vertical = 20.dp))
            }
            if (isLoading) {
                CircularProgressIndicator()
            }
        }
    }
}

@Preview
@Composable
fun MoreTemplatePreview() {
    Yatter2023Theme() {
        Surface() {
            MoreTemplate(
                statusBindingModel = StatusBindingModel(
                    id = "id",
                    displayName = "mito",
                    username = "mitohato14",
                    avatar = "https://avatars.githubusercontent.com/u/19385268?v=4",
                    content = "preview content",
                    attachmentMediaList = listOf(
                        MediaBindingModel(
                            id = "id",
                            type = "image",
                            url = "https://avatars.githubusercontent.com/u/39693306?v=4",
                            description = "icon"
                        )
                    )
                ),
                isLoading = false,
                onClickGoBack = {},
            )
        }
    }
}
