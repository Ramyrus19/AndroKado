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

    Article article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_article);

        Intent intent = getIntent();
        article = intent.getParcelableExtra("article");

        etNom = findViewById(R.id.et_nom);
        etPrix = findViewById(R.id.et_price);
        etDescription = findViewById(R.id.et_description);
        etUrl = findViewById(R.id.et_url);
        tbEtat = findViewById(R.id.tb_etat);
        rbNote = findViewById(R.id.rb_note);

    }

    @Override
    protected void onResume() {
        super.onResume();
        ArticleDao dao = new ArticleDao(this);
        article = dao.get(article.getId());
        if (article != null){
            etNom.setText(article.getNom());
            String prixAsString = article.getPrix().toString();
            etPrix.setText(prixAsString);
            etDescription.setText(article.getDescription());
            etUrl.setText(article.getUrl());
            rbNote.setRating(article.getNote());
            tbEtat.setChecked(article.getEtat());
        }
    }

    public void onSaveClick(View view) {
        ArticleDao dao = new ArticleDao(this);
        //retrieve the user input data
        String nom = etNom.getText().toString();
        Double prix = Double.parseDouble(etPrix.getText().toString());
        String description = etDescription.getText().toString();
        float note = rbNote.getRating();
        String url = etUrl.getText().toString();
        boolean etat = tbEtat.isChecked();

        if (article == null){
            Article newArticle = new Article(nom, prix, description, note, url, etat);

            long id = dao.insert(newArticle);
        }else{
            article.setNom(nom);
            article.setPrix(prix);
            article.setDescription(description);
            article.setNote(note);
            article.setUrl(url);
            article.setEtat(etat);
            dao.update(article);
        }

        finish();
    }


}