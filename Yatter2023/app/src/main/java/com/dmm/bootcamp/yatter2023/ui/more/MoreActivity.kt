package com.dmm.bootcamp.yatter2023.ui.more

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Surface
import com.dmm.bootcamp.yatter2023.ui.theme.Yatter2023Theme
import com.dmm.bootcamp.yatter2023.ui.timeline.PublicTimelineActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoreActivity : AppCompatActivity() {
    companion object {
        private const val KEY_TEXT: String = "text"
        fun newIntent(context: Context): Intent = Intent(
            context,
            MoreActivity::class.java,
        )
    }

    private val viewModel: MoreViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Log.d("Debug"," Value : ${intent.getStringExtra(KEY_TEXT)}")

        val currentNum: String? = intent.getStringExtra(KEY_TEXT)
        viewModel.uiState.value.currentNum = currentNum!!

        viewModel.navigateToPublicTimeline.observe(this) {
            startActivity(PublicTimelineActivity.newIntent(this))
            finish()
        }

        setContent {
            Yatter2023Theme {
                Surface {
                    MorePage(viewModel = viewModel)
                }
            }
        }
    }

    override fun onResume(){
        super.onResume()
        viewModel.onResume()
    }
}