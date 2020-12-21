package com.google.samples.apps.sunflower_java.data;


import androidx.lifecycle.LiveData;

import com.google.samples.apps.sunflower_java.api.UnsplashService;

import javax.inject.Inject;

public class UnsplashRepository {
    private static final int NETWORK_PAGE_SIZE = 25;

    @Inject
    public UnsplashRepository(UnsplashService service){}

    public final LiveData getSearchResultStream(final String query) {

        return null;
    }
}
