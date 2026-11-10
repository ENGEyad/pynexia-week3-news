package com.pynexia.week3.news;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.util.ArrayList;
public final class MainActivity extends ComponentActivity {
 private final NewsRepository repository=new NewsRepository(); private String category="Technology"; private ArticleAdapter adapter; private TextView status; private long requestVersion=0;
 @Override protected void onCreate(Bundle state) { super.onCreate(state); setContentView(R.layout.activity_main); status=findViewById(R.id.status); RecyclerView list=findViewById(R.id.articleList); list.setLayoutManager(new LinearLayoutManager(this)); adapter=new ArticleAdapter(this::showArticle); list.setAdapter(adapter); SwipeRefreshLayout swipe=findViewById(R.id.swipe); swipe.setColorSchemeColors(0xff246a5b); swipe.setOnRefreshListener(()->load(swipe)); findViewById(R.id.tech).setOnClickListener(v->select("Technology",swipe)); findViewById(R.id.business).setOnClickListener(v->select("Business",swipe)); findViewById(R.id.sports).setOnClickListener(v->select("Sports",swipe)); findViewById(R.id.retry).setOnClickListener(v->load(swipe)); load(swipe); }
 private void select(String value,SwipeRefreshLayout swipe) { category=value; status.setText("Latest "+value.toLowerCase()+" headlines"); load(swipe); }
 private void load(SwipeRefreshLayout swipe) { final long request=++requestVersion; final String requestedCategory=category; status.setText("Loading "+category.toLowerCase()+" headlines…"); findViewById(R.id.retry).setVisibility(View.GONE); swipe.setRefreshing(true); repository.fetch(category,(response,error)->runOnUiThread(()->{ if(request!=requestVersion||isFinishing())return; swipe.setRefreshing(false); adapter.replace(response.articles); if (error!=null) { status.setText(error); findViewById(R.id.retry).setVisibility(View.VISIBLE); } else { status.setText(response.articles.isEmpty()?"No recent stories found. Pull down to refresh.":response.articles.size()+" recent stories · tap one to read details"); } })); }
 private void showArticle(GdeltArticle a) { Intent i=new Intent(this,ArticleActivity.class); i.putExtra("title",a.safeTitle()); i.putExtra("url",a.url); i.putExtra("domain",a.domain); i.putExtra("date",a.displayDate()); i.putExtra("image",a.imageUrl); startActivity(i); }
}
