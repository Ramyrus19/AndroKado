package com.example.androkado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.ToggleButton;

import com.example.androkado.bo.Article;
import com.example.androkado.dal.ArticleDao;

public class CreateArticleActivity extends AppCompatActivity {

    EditText etNom;
    EditText etPrix;
    EditText etDescription;
    EditText etUrl;
    ToggleButton tbEtat;
    RatingBar rbNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_article);

        etNom = findViewById(R.id.et_nom);
        etPrix = findViewById(R.id.et_price);
        etDescription = findViewById(R.id.et_description);
        etUrl = findViewById(R.id.et_url);
        tbEtat = findViewById(R.id.tb_etat);
        rbNote = findViewById(R.id.rb_note);
    }

    public void onSaveClick(View view) {
        Article article = new Article(
                etNom.getText().toString(),
                Double.parseDouble(etPrix.getText().toString()),
                etDescription.getText().toString(),
                rbNote.getRating(),
                etUrl.getText().toString(),
                tbEtat.isChecked()
        );

        ArticleDao dao = new ArticleDao(this);
        long id = dao.insert(article);

        finish();
    }


}