package com.pynexia.week3.news;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public final class NewsRepository {
 public interface Callback { void complete(GdeltResponse response, String error); }
 private final GdeltApi api = new Retrofit.Builder().baseUrl("https://api.gdeltproject.org/").client(new okhttp3.OkHttpClient.Builder().connectTimeout(8,java.util.concurrent.TimeUnit.SECONDS).readTimeout(15,java.util.concurrent.TimeUnit.SECONDS).callTimeout(20,java.util.concurrent.TimeUnit.SECONDS).build()).addConverterFactory(GsonConverterFactory.create()).build().create(GdeltApi.class);
 public void fetch(String category, Callback callback) {
  String query = "technology";
  if ("Business".equals(category)) query = "business";
  if ("Sports".equals(category)) query = "sports";
  api.search(query, "ArtList", "json", 30, "DateDesc").enqueue(new retrofit2.Callback<GdeltResponse>() {
   @Override public void onResponse(retrofit2.Call<GdeltResponse> call, retrofit2.Response<GdeltResponse> response) {
    if (response.isSuccessful() && response.body() != null && response.body().articles != null) callback.complete(response.body(), null);
    else callback.complete(GdeltResponse.samples(category), "News service returned HTTP " + response.code() + ". Showing a clearly marked sample story; pull to refresh for live headlines.");
   }
   @Override public void onFailure(retrofit2.Call<GdeltResponse> call, Throwable error) { callback.complete(GdeltResponse.samples(category), "Could not load live headlines. Showing a clearly marked sample story; check your connection and try again."); }
  });
 }
}
