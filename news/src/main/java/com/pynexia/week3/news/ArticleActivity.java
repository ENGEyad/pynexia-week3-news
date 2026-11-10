package com.pynexia.week3.news;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import com.bumptech.glide.Glide;
public final class ArticleActivity extends ComponentActivity {
 @Override protected void onCreate(Bundle state) { super.onCreate(state); setContentView(R.layout.activity_article); Intent i=getIntent(); ((TextView)findViewById(R.id.detailTitle)).setText(i.getStringExtra("title")); ((TextView)findViewById(R.id.detailSource)).setText((i.getStringExtra("domain")==null?"News source":i.getStringExtra("domain"))+" · "+i.getStringExtra("date")); Glide.with(this).load(i.getStringExtra("image")).centerCrop().placeholder(R.drawable.card).error(R.drawable.card).into((ImageView)findViewById(R.id.detailImage)); Button open=findViewById(R.id.openArticle); String url=i.getStringExtra("url"); if(url==null||!(url.startsWith("https://")||url.startsWith("http://"))){open.setVisibility(android.view.View.GONE);((TextView)findViewById(R.id.detailTitle)).append(" - Offline sample, no live source.");} else open.setOnClickListener(v->startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(url)))); }
}
