package com.google.samples.apps.sunflower_java.viewmodels;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.google.samples.apps.sunflower_java.data.UnsplashPhoto;
import com.google.samples.apps.sunflower_java.data.UnsplashRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class  GalleryViewModel extends ViewModel {
    private String currentQueryValue;
    private LiveData currentSearchResult;
    private final UnsplashRepository repository;

    @NotNull
    public final LiveData<List<UnsplashPhoto>> searchPictures(String queryString) {
        this.currentQueryValue = queryString;
        LiveData newResult = null;
        this.currentSearchResult = newResult;
        return newResult;
    }

    @ViewModelInject
    public GalleryViewModel(UnsplashRepository repository) {
        super();
        this.repository = repository;
    }
}
