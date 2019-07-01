package com.loan.dai.base;


import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.loan.dai.R;
import com.loan.dai.base.basepresenter.BasePresenter;

public class WebActivity extends BaseActivity implements View.OnClickListener {

    private WebView wb;
    private ProgressBar pb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_layout);
        TextView title = findViewById(R.id.title_des_tv);
        pb = findViewById(R.id.web_pb);
        wb = findViewById(R.id.wb);
        title.setText("活动");
        findViewById(R.id.title_left_arrows).setOnClickListener(this);

        wb.loadUrl("https://www.baidu.com");
        wb.getSettings().setJavaScriptEnabled(true);
        WebSettings settings = wb.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(false);
        settings.setUseWideViewPort(false);

        wb.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                try {
                    if (newProgress == 100) {
                        pb.setVisibility(View.GONE);
                    } else {
                        pb.setProgress(newProgress);
                        pb.setVisibility(View.VISIBLE);
                    }
                } catch (Exception e) {
                }

            }
        });

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
