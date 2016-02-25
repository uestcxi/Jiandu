package com.jason.jiandu.atys;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gc.materialdesign.views.ProgressBarCircularIndeterminate;
import com.jason.jiandu.R;
import com.jason.jiandu.bmob.ArticleObj;
import com.jason.jiandu.bmob.GetArticle;
import com.jason.jiandu.views.JustifyTextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ArticleActivity extends AppCompatActivity
{
    private TextView mArtTitle;
    private TextView mArtAuthor;
    private JustifyTextView mArtContent;

    private ProgressBarCircularIndeterminate mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        mArtAuthor = (TextView) findViewById(R.id.tv_author);
        mArtContent = (JustifyTextView) findViewById(R.id.tv_content);
        mArtTitle = (TextView) findViewById(R.id.tv_title);

        Typeface typeFace =Typeface.createFromAsset(getAssets(), "fonts/Roboto-Black.ttf");
        mArtContent.setTypeface(typeFace);

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
        String time = format.format(new Date());

        mProgressBar = (ProgressBarCircularIndeterminate) findViewById(R.id.progressBar);

        new GetArticle(ArticleActivity.this, time, new GetArticle.SuccessCallback()
        {
            @Override
            public void onSuccess(ArticleObj art)
            {
                mArtTitle.setText(art.getArtTitle());
                mArtAuthor.setText(art.getArtAuthor());
                String s = art.getArtContent() + "\n";
                mArtContent.setText(s);
                mProgressBar.setVisibility(View.GONE);
            }
        }, new GetArticle.FailCallback()
        {
            @Override
            public void onFail(int i, String s)
            {
                mProgressBar.setVisibility(View.GONE);
                Toast.makeText(ArticleActivity.this, "错误代码:" + i + "  " + s, Toast.LENGTH_LONG).show();
            }
        });
    }
}
