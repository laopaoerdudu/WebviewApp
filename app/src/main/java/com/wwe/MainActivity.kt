package com.wwe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class MainActivity : AppCompatActivity() {
    private val mWebView: WebView by lazy {
        findViewById(R.id.web_container)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mWebView.settings.apply {
            javaScriptEnabled = true
            allowFileAccess = true
            builtInZoomControls = true
            setSupportZoom(true)
            displayZoomControls = false //不显示缩放按钮
        }

        mWebView.loadUrl("file:///android_asset/index.html?https://www.gjtool.cn/pdfh5/git.pdf")
    }

    override fun onDestroy() {
        super.onDestroy()
        mWebView.apply {
            clearHistory()
            clearCache(true)
            clearFormData()
        }
    }
}