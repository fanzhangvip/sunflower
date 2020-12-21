package com.google.samples.apps.sunflower_java.di;


import com.google.samples.apps.sunflower_java.api.UnsplashService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@InstallIn({ApplicationComponent.class})
@Module
public class NetworkModule {

    @Singleton
    @Provides
    public final UnsplashService provideUnsplashService() {
        return UnsplashService.create();
    }
}
