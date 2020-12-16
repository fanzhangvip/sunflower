/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.sunflower_java.di;

import android.content.Context;

import com.google.samples.apps.sunflower_java.data.AppDatabase;
import com.google.samples.apps.sunflower_java.data.GardenPlantingDao;
import com.google.samples.apps.sunflower_java.data.PlantDao;


import javax.inject.Singleton;

import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;

@InstallIn({ApplicationComponent.class})
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
