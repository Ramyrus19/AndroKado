package com.example.androkado.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androkado.R;
import com.example.androkado.bo.Article;

import java.util.ArrayList;
import java.util.List;

public class ListeArticlesAdapter extends RecyclerView.Adapter<ListeArticlesAdapter.ViewHolder>
{
    private ArrayList<Article> listeArticles;
    private OnClicSurUnItem<Article> action;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView tvName;
        public TextView tvPrice;
        public TextView tvDescription;
        public RatingBar rbNote;

        ViewHolder(View v)
        {
            super(v);
            tvName = v.findViewById(R.id.tv_name);
            tvPrice = v.findViewById(R.id.tv_price);
            tvDescription = v.findViewById(R.id.tv_description);
            rbNote = v.findViewById(R.id.rb_note);

            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            action.onInteraction(listeArticles.get(ViewHolder.this.getAdapterPosition()));
        }
    }

    public interface OnClicSurUnItem<T> {
        void onInteraction(T article);
    }

    public ListeArticlesAdapter(List<Article> myDataset, OnClicSurUnItem<Article> activite)
    {
        listeArticles = (ArrayList<Article>)myDataset;
        action = activite;
    }

    @Override
    public ListeArticlesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.line_design, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvName.setText(listeArticles.get(position).getNom());
        String prixAsString = listeArticles.get(position).getPrix() + " €";
        holder.tvPrice.setText(prixAsString);
        holder.tvDescription.setText(listeArticles.get(position).getDescription());
        holder.rbNote.setRating(listeArticles.get(position).getNote());
    }

    @Override
    public int getItemCount() {
        return listeArticles.size();
    }
}
