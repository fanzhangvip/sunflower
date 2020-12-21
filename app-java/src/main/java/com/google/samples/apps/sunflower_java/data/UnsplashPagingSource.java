package com.google.samples.apps.sunflower_java.data;

import androidx.paging.PagingSource;

import com.google.samples.apps.sunflower_java.api.UnsplashService;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import kotlin.coroutines.Continuation;


public class UnsplashPagingSource extends PagingSource<Integer,UnsplashPhoto> {

    private UnsplashService service;
    private String query;

    public UnsplashPagingSource(UnsplashService service,String query){
        this.service = service;
        this.query = query;
    }


    @Nullable
    @Override
    public Object load(@NotNull LoadParams<Integer> loadParams, @NotNull Continuation<? super LoadResult<Integer, UnsplashPhoto>> continuation) {
        return null;
    }
}
