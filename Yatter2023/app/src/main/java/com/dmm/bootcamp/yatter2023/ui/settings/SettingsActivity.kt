package com.dmm.bootcamp.yatter2023.ui.settings

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Surface
import com.dmm.bootcamp.yatter2023.ui.account.AccountActivity
import com.dmm.bootcamp.yatter2023.ui.login.LoginActivity
import com.dmm.bootcamp.yatter2023.ui.theme.Yatter2023Theme
import com.dmm.bootcamp.yatter2023.ui.timeline.PublicTimelineActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsActivity : AppCompatActivity() {
    companion object {
        fun newIntent(context: Context): Intent = Intent(
            context,
            SettingsActivity::class.java,
        )
    }

    private val viewModel: SettingsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Yatter2023Theme {
                Surface {
                    SettingsPage(viewModel = viewModel)
                }
            }
        }

        viewModel.navigateToPublicTimelineFromSettings.observe(this) {
            startActivity(PublicTimelineActivity.newIntent(this))
            finish()
        }

        viewModel.navigateToAccount.observe(this){
            startActivity(AccountActivity.newIntent(this))
            finish()
        }

        viewModel.navigateToLogin.observe(this){
            startActivity(LoginActivity.newIntent(this))
            finish()
        }
    }
}