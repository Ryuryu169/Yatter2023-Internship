package com.dmm.bootcamp.yatter2023.ui.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EachSettings(
    onClickAccount: () -> Unit,
    onClickFollower: () -> Unit,
    onClickSignOut: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        //contentPadding = PaddingValues(8.dp),
    ) {
        //item {
        // Spacer(modifier = Modifier.size(30.dp))
        TemplateSettings(
            description = "アカウントの設定",
            icon = Icons.Default.AccountCircle,
            onClick = onClickAccount
        )
        Divider(modifier = Modifier.padding(vertical = 10.dp))
        //}
        //item {
        TemplateSettings(
            description = "フォロワー",
            icon = Icons.Rounded.Person,
            onClick = onClickFollower
        )
        Divider(modifier = Modifier.padding(vertical = 10.dp))
        //}
        //item {
        TemplateSettings(
            description = "サインアウト",
            icon = Icons.Default.ExitToApp,
            onClick = onClickSignOut
        )
        Divider(modifier = Modifier.padding(vertical = 10.dp))
        //}
        //item {
        TemplateSettings(
            description = "利用規約",
            icon = Icons.Default.Info,
            onClick = {}
        )
        //}
    }
}

@Composable
fun TemplateSettings(
    description: String,
    icon: ImageVector,
    onClick: () -> Unit,
) {
    Row(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
        IconButton(
            modifier = Modifier.size(width= 48.dp,height = 48.dp),
            onClick = onClick
        ) {
            Icon(
                imageVector = icon,
                contentDescription = description,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            )
        }
        Spacer(Modifier.size(20.dp))
        Text(text = description, fontSize = 20.sp, modifier = Modifier.align(Alignment.CenterVertically))
    }
}

@Preview
@Composable
fun TemplateView() {
    TemplateSettings(description = "Hello", icon = Icons.Default.ExitToApp) {

    }
}