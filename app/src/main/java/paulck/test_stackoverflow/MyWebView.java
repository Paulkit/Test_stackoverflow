package paulck.test_stackoverflow;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebView extends WebView {

    public MyWebView(Context context) {
        super(context);
        initView(context);
    }

    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

        @SuppressLint("SetJavaScriptEnabled")
        private void initView(Context context){

            this.getSettings().setJavaScriptEnabled(true) ;
            this.getSettings().setUseWideViewPort(true);
            this.getSettings().setLoadWithOverviewMode(true);
            this.getSettings().setDomStorageEnabled(true);
            this.setWebViewClient(new WebViewClient() {

                  @Override
                  public void onReceivedError(final WebView view, int errorCode, String description,
                                              final String failingUrl) {

                          MyWebView.this.loadUrl("file:///android_asset/error.html");

                  }

                  @TargetApi(Build.VERSION_CODES.M)
                  @Override
                  public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError errorResponse) {

                          MyWebView.this.loadUrl("file:///android_asset/error.html");
                  }
              });

        }

    }
