package com.google.samples.apps.sunflower_java.di;

import android.content.Context;

import com.google.samples.apps.sunflower_java.data.AppDatabase;
import com.google.samples.apps.sunflower_java.data.GardenPlantingDao;
import com.google.samples.apps.sunflower_java.data.PlantDao;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;

@InstallIn({ApplicationComponent.class})
@Module
public class DatabaseModule {
    @Singleton
    @Provides
    public final AppDatabase provideAppDatabase(@ApplicationContext Context context) {
        return AppDatabase.getInstance(context);
    }

    @Provides
    public final PlantDao providePlantDao(AppDatabase appDatabase) {
        return appDatabase.getPlantDao();
    }

    @Provides
    public final GardenPlantingDao provideGardenPlantingDao(AppDatabase appDatabase) {
        return appDatabase.getGardenPlantingDao();
    }
}
