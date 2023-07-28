package com.dmm.bootcamp.yatter2023.ui.account

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.dmm.bootcamp.yatter2023.ui.theme.Yatter2023Theme
import com.dmm.bootcamp.yatter2023.ui.timeline.PublicTimelineActivity
import com.dmm.bootcamp.yatter2023.ui.updateuser.UpdateUserActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class AccountActivity : ComponentActivity() {
    companion object {
        fun newIntent(context: Context): Intent = Intent(
            context,
            AccountActivity::class.java,
        )
    }
    private val viewModel: AccountViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Yatter2023Theme {
                Surface {
                    AccountPage(viewModel = viewModel)
                }
            }
        }

        viewModel.navigateToEdit.observe(this){
            startActivity(UpdateUserActivity.newIntent(this))
            finish()
        }

        viewModel.goBack.observe(this) {
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }
}