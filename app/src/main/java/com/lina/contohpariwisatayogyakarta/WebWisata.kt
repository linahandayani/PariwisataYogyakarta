package com.lina.contohpariwisatayogyakarta

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

class WebWisata : Fragment() {
    lateinit var webView: WebView
    lateinit var pb: ProgressBar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Website Wisata"
        webView=view.findViewById(R.id.webview)
        pb=view.findViewById(R.id.pb)
        webView.settings.javaScriptEnabled=true
        webView.settings.saveFormData= true

        webView.webViewClient = object : WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }
        }

        webView.webChromeClient=object : WebChromeClient(){
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                if (newProgress===100){
                    pb.visibility=View.GONE
                    }
            }
        }
        webView.loadUrl("https://www.jogjaprov.go.id/")
    }

}
