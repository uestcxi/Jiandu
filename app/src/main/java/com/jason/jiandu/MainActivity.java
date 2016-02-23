package com.jason.jiandu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jason.jiandu.atys.ArticleActivity;

import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initial bmob
        Bmob.initialize(this, "c9e12da55524ccffa01dfce7d9ac1efe");

        startActivity(new Intent(MainActivity.this, ArticleActivity.class));
        finish(); 
    }
}
