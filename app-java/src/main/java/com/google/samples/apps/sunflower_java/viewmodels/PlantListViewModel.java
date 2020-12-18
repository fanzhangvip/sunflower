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

package com.google.samples.apps.sunflower_java.viewmodels;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.google.samples.apps.sunflower_java.data.Plant;
import com.google.samples.apps.sunflower_java.data.PlantRepository;

import java.util.List;


public final class PlantListViewModel extends ViewModel {
    private static final int NO_GROW_ZONE = -1;
    private static final String GROW_ZONE_SAVED_STATE_KEY = "GROW_ZONE_SAVED_STATE_KEY";

    private final SavedStateHandle savedStateHandle;

    private PlantRepository plantRepository;

    private MutableLiveData<Integer> growZone;

    public LiveData<List<Plant>> plants;


    public final LiveData getPlants() {
        return this.plants;
    }

    public final void setGrowZoneNumber(int num) {
        growZone.setValue(num);
    }

    public final void clearGrowZoneNumber() {
        growZone.setValue(NO_GROW_ZONE);
    }

    public final boolean isFiltered() {
        return growZone.getValue() != NO_GROW_ZONE;
    }

    @ViewModelInject
    public PlantListViewModel( PlantRepository plantRepository, @Assisted  SavedStateHandle savedStateHandle) {
        super();
        this.savedStateHandle = savedStateHandle;
        this.plantRepository = plantRepository;
        Integer zone_saved = savedStateHandle.get(GROW_ZONE_SAVED_STATE_KEY);
        growZone = new MutableLiveData<>(zone_saved == null? -1: zone_saved);
        plants = Transformations.switchMap(growZone, it -> {
            if (it == NO_GROW_ZONE) {
                return plantRepository.getPlants();
            } else {
                return plantRepository.getPlantsWithGrowZoneNumber(it);
            }
        });

    }


}
