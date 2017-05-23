package com.example.administrator.qgweibo.View.Activities

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.administrator.qgweibo.R
import com.example.administrator.qgweibo.View.Interfaces.INewsWebView
import kotlinx.android.synthetic.main.activity_news_webview.*

class NewsWebViewActivity : BaseActivity(),  INewsWebView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_webview)
        var url : String? = intent.getStringExtra("newsUrl")
        initWebView()
        if(url != null){
            newsWebview.loadUrl(url)
        }
    }

    override fun initWebView(){
        val webSettings = newsWebview.settings
        webSettings.javaScriptEnabled = true
        newsWebview.setWebViewClient(object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view!!.loadUrl(url)
                return true
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }
        })
    }

}
