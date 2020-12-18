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

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.google.samples.apps.sunflower_java.data.GardenPlantingRepository;

import org.jetbrains.annotations.NotNull;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

public final class GardenPlantingListViewModel extends ViewModel {

    private  LiveData plantAndGardenPlantings;

    public final LiveData getPlantAndGardenPlantings() {
        return this.plantAndGardenPlantings;
    }

    @ViewModelInject
    public GardenPlantingListViewModel(GardenPlantingRepository gardenPlantingRepository) {
        super();
        //需要修改
//        this.plantAndGardenPlantings = FlowLiveDataConversions.asLiveData$default(gardenPlantingRepository.getPlantedGardens(), (CoroutineContext)null, 0L, 3, (Object)null);
    }
}
