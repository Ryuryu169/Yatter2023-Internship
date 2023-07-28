package com.dmm.bootcamp.yatter2023.ui.timeline

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Surface
import androidx.core.content.ContextCompat.startActivity
import com.dmm.bootcamp.yatter2023.ui.more.MoreActivity
import com.dmm.bootcamp.yatter2023.ui.post.PostActivity
import com.dmm.bootcamp.yatter2023.ui.settings.SettingsActivity
import com.dmm.bootcamp.yatter2023.ui.theme.Yatter2023Theme
import org.koin.androidx.viewmodel.ext.android.viewModel

class PublicTimelineActivity : AppCompatActivity() {
    companion object {
        fun newIntent(context: Context): Intent = Intent(
            context,
            PublicTimelineActivity::class.java,
        )
    }

    private val viewModel: PublicTimelineViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.navigateToPost.observe(this) {
            startActivity(PostActivity.newIntent(this))
        }

        viewModel.navigateToSettings.observe(this) {
            startActivity(SettingsActivity.newIntent(this))
        }

        viewModel.navigateToMore.observe(this) {
            val intent = MoreActivity.newIntent(this)
            intent.putExtra("text",viewModel.uiState.value.currentNum)
            startActivity(intent)
        }

        setContent {
            Yatter2023Theme {
                Surface {
                    PublicTimelinePage(viewModel = viewModel)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }
}