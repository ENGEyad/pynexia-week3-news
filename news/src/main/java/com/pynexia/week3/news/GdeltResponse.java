package com.pynexia.week3.news;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
public final class GdeltResponse {
 @SerializedName("articles") public List<GdeltArticle> articles = new ArrayList<>();
 public static GdeltResponse samples(String category) { GdeltResponse result=new GdeltResponse();GdeltArticle a=new GdeltArticle();a.title="Sample story: Exploring current "+category.toLowerCase()+" topics";a.domain="Offline sample";a.seenDate="20261110T000000Z";a.imageUrl="https://images.unsplash.com/photo-1518770660439-4636190af475?w=900";a.sampleOnly=true;result.articles.add(a);return result; }
}
