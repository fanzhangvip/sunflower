package com.google.samples.apps.sunflower_java.api;

import com.google.samples.apps.sunflower_java.BuildConfig;
import com.google.samples.apps.sunflower_java.data.UnsplashSearchResponse;

import org.jetbrains.annotations.NotNull;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

public interface UnsplashService {

    String BASE_URL = "https://api.unsplash.com/";

    static UnsplashService create(){
        HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
        logger.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(logger).build();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(UnsplashService.class);
    }

    UnsplashSearchResponse searchPhotos(@Query("query") @NotNull String query, @Query("page") int page, @Query("per_page") int per_page, @Query("client_id") @NotNull String client_id);

}
