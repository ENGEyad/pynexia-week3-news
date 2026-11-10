package com.pynexia.week3.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;
public final class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.Holder> {
 public interface Listener { void open(GdeltArticle article); }
 private final List<GdeltArticle> items = new ArrayList<>(); private final Listener listener;
 ArticleAdapter(Listener listener) { this.listener = listener; }
 void replace(List<GdeltArticle> values) { items.clear(); if (values != null) items.addAll(values); notifyDataSetChanged(); }
 @NonNull @Override public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_article,parent,false)); }
 @Override public void onBindViewHolder(@NonNull Holder h,int position) { GdeltArticle a=items.get(position); h.title.setText(a.safeTitle()); h.meta.setText((a.domain == null ? "World news" : a.domain)+"  ·  "+(a.sampleOnly?"Demo, not live news":a.displayDate())); Glide.with(h.image).load(a.imageUrl).centerCrop().placeholder(R.drawable.card).error(R.drawable.card).into(h.image); h.itemView.setOnClickListener(v->listener.open(a)); }
 @Override public int getItemCount() { return items.size(); }
 static final class Holder extends RecyclerView.ViewHolder { final TextView title,meta; final ImageView image; Holder(View v) { super(v); title=v.findViewById(R.id.articleTitle); meta=v.findViewById(R.id.articleMeta); image=v.findViewById(R.id.articleImage); } }
}
