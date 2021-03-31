package com.example.androkado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

import com.example.androkado.bo.Article;

public class InfoUrlActivity extends AppCompatActivity {
    Article article;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_url);
        //retrieve the intent and set the extra as value of the textview
        Intent intent = getIntent();
        article = intent.getParcelableExtra("article");
        tv = findViewById(R.id.tv_url);
        tv.setText(article.getUrl());
    }

}