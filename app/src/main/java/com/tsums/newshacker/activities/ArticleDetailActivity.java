package com.tsums.newshacker.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;

import com.f2prateek.dart.Dart;
import com.f2prateek.dart.InjectExtra;
import com.tsums.newshacker.R;
import com.tsums.newshacker.models.HNItem;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ArticleDetailActivity extends AppCompatActivity {

    public static final String EXTRA_ARTICLE = "extra_article";

    @InjectView (R.id.activity_article_detail_toolbar) Toolbar toolbar;
    @InjectView (R.id.activity_article_detail_webview) WebView webview;

    @InjectExtra (EXTRA_ARTICLE) HNItem article;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_article_detail);
        ButterKnife.inject(this);
        Dart.inject(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle(article.title);

        webview.loadUrl(article.url);

    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
