package com.vickikbt.gistagram.ui.screens.webview

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import com.vickikbt.gistagram.utils.Constants

@Composable
fun WebViewScreen(url: String = Constants.GITHUB_OAUTH_URL) {
    AndroidView(factory = {
        val apply = WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            loadUrl(url)
        }
        apply
    }, update = {
        it.loadUrl(url)
    }
    )
}