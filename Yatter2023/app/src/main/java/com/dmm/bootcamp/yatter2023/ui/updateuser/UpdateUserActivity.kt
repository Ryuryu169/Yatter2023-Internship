package com.dmm.bootcamp.yatter2023.ui.updateuser

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Surface
import com.dmm.bootcamp.yatter2023.ui.post.PostActivity
import com.dmm.bootcamp.yatter2023.ui.settings.SettingsActivity
import com.dmm.bootcamp.yatter2023.ui.theme.Yatter2023Theme
import com.dmm.bootcamp.yatter2023.ui.timeline.PublicTimelineActivity
import com.dmm.bootcamp.yatter2023.ui.timeline.PublicTimelinePage
import com.dmm.bootcamp.yatter2023.ui.timeline.PublicTimelineViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class UpdateUserActivity : AppCompatActivity() {
    companion object {
        fun newIntent(context: Context): Intent = Intent(
            context,
            UpdateUserActivity::class.java,
        )
    }

    private val viewModel: UpdateUserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Yatter2023Theme {
                Surface {
                    UpdateUserPage(viewModel = viewModel)
                }
            }
        }

        viewModel.navigateToPublicTimeline.observe(this){
            startActivity(PublicTimelineActivity.newIntent(this))
            finish()
        }

        viewModel.goBack.observe(this) {
            finish()
        }
    }
}