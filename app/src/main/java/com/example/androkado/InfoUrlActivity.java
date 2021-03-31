package com.example.androkado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

import com.example.androkado.bo.Article;

public class InfoUrlActivity extends AppCompatActivity {
    private Article article;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_url);
        //retrieve the intent and the text view
        tv = findViewById(R.id.tv_url);
        Intent intent = getIntent();
        article = intent.getParcelableExtra("article");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //set the extra as value of the textview
        tv.setText(article.getUrl());
    }
}