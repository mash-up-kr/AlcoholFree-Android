package com.mashup.alcoholfree.presentation.ui.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.mashup.alcoholfree.presentation.ui.component.SulSulBackButton
import com.mashup.alcoholfree.presentation.ui.component.SulSulWebView
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import com.mashup.alcoholfree.presentation.utils.observeEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterTierActivity : ComponentActivity() {
    private val viewModel by viewModels<RegisterTierViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            AlcoholFreeAndroidTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    SulSulWebView(
                        modifier = Modifier
                            .fillMaxSize(),
                        url = "https://dev-onboarding.sulsul.app/measure",
                        isTransparent = false,
                        bridge = RegisterTierBridge(
                            onSuccess = viewModel::registerTier
                        ),
                        state = null,
                    )

                    SulSulBackButton(
                        modifier = Modifier
                            .statusBarsPadding()
                            .padding(top = 8.dp, start = 16.dp)
                            .align(Alignment.TopStart),
                        onClick = { finish() }
                    )
                }
            }
        }
        observeData()
    }

    private fun observeData() {
        viewModel.successEvent.observeEvent(this) {
            setResult(RESULT_OK)
            finish()
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, RegisterTierActivity::class.java)
        }
    }
}
