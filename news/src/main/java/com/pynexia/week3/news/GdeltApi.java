package com.pynexia.week3.news;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface GdeltApi {
 @GET("api/v2/doc/doc") Call<GdeltResponse> search(@Query("query") String query, @Query("mode") String mode, @Query("format") String format, @Query("maxrecords") int limit, @Query("sort") String sort);
}
