package paulck.test_stackoverflow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {


    WebView mWebView;



    final String paypal_url = "https://www.paypal.com/welcome/signup/#/email_password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fillField();

    }

    private void fillField() {
        mWebView = (WebView) findViewById(R.id.web_view);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl(paypal_url);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

              view.loadUrl( "javascript:window.onload= (function(){ document.getElementById('paypalAccountData_firstName').value = 'test';})();");

            }

        });

    }
}

