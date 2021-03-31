package com.example.androkado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.androkado.bo.Article;

public class MainActivity extends AppCompatActivity {
    private Article article;
    TextView tvName;
    TextView tvPrice;
    TextView tvDescription;
    RatingBar rb;
    private ToggleButton tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        article = new Article("Pain au chocolat", 2.15, "Une viennoiserie au beurre salé et au chocolat", 3.5f, "http://painauchocolat.fr", true);
        //show article in view
        tb = findViewById(R.id.tb_status);
        tvName = findViewById(R.id.tv_name);
        tvPrice = findViewById(R.id.tv_price);
        tvDescription = findViewById(R.id.tv_description);
        rb = findViewById(R.id.rb_review);

    }

    @Override
    protected void onResume() {
        super.onResume();
        tvName.setText(article.getNom());
        String prixAsString = article.getPrix() + " €";
        tvPrice.setText(prixAsString);
        tvDescription.setText(article.getDescription());
        rb.setRating(article.getNote());
        tb.setChecked(article.getEtat());
    }

    public void onSearchClick(View view) {
        //show a toast with the url of the article on button click
        Toast toast = Toast.makeText(this, article.getUrl(), Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();

        //navigate to InfoUrlActivity
        Intent intent = new Intent(this, InfoUrlActivity.class);
        intent.putExtra("article", article);
        startActivity(intent);
    }

    public void onToggle(View view) {
        //set the article state depending on the value of the toggle button
        boolean state = tb.isChecked();
        article.setEtat(state);
        //Log.v("ArticleState", article.getEtat().toString());
    }
}