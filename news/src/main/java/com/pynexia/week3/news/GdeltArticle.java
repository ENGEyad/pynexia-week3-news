package com.pynexia.week3.news;

import com.google.gson.annotations.SerializedName;
public final class GdeltArticle {
 @SerializedName("title") public String title;
 @SerializedName("url") public String url;
 @SerializedName("seendate") public String seenDate;
 @SerializedName("domain") public String domain;
 @SerializedName("sourcecountry") public String sourceCountry;
 @SerializedName("socialimage") public String imageUrl;
 public boolean sampleOnly;
 public String displayDate() {
  if (seenDate == null || seenDate.length() < 8) return "Recently reported";
  return seenDate.substring(0,4)+"-"+seenDate.substring(4,6)+"-"+seenDate.substring(6,8);
 }
 public String safeTitle() { return title == null || title.isBlank() ? "Untitled article" : title; }
}
