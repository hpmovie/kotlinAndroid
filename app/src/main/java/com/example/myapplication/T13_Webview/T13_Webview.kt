package com.example.myapplication.T13_Webview

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_t13__webview.*

class T13_Webview : AppCompatActivity() {

    inner class MyWebViewClient:WebViewClient() {
        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            loadingProgress.visibility = View.VISIBLE
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            loadingProgress.visibility = View.GONE
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t13__webview)

        loadingProgress.visibility = View.GONE
        myWebview.webViewClient = MyWebViewClient()
        myWebview.settings.javaScriptEnabled = true
        myWebview.loadUrl("http://daum.net")
    }

    override fun onBackPressed() {
        if(myWebview.canGoBack()) {
            myWebview.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
