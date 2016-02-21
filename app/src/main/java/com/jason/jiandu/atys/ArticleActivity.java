package com.jason.jiandu.atys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.jason.jiandu.R;
import com.jason.jiandu.bmob.ArticleObj;
import com.jason.jiandu.bmob.GetArticle;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ArticleActivity extends AppCompatActivity
{
    private TextView mArtTitle;
    private TextView mArtAuthor;
    private TextView mArtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        mArtAuthor = (TextView) findViewById(R.id.tv_author);
        mArtContent = (TextView) findViewById(R.id.tv_content);
        mArtTitle = (TextView) findViewById(R.id.tv_title);

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String time = format.format(new Date());

        new GetArticle(ArticleActivity.this, time, new GetArticle.SuccessCallback()
        {
            @Override
            public void onSuccess(ArticleObj art)
            {
                mArtTitle.setText(art.getArtTitle());
                mArtAuthor.setText(art.getArtAuthor());
                mArtContent.setText(art.getArtContent());
            }
        }, new GetArticle.FailCallback()
        {
            @Override
            public void onFail(int i, String s)
            {
                Toast.makeText(ArticleActivity.this, "错误代码:" + i + "  " + s, Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}
