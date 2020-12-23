package com.google.samples.apps.sunflower_java.viewmodels;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.google.samples.apps.sunflower_java.data.GardenPlantingRepository;
import com.google.samples.apps.sunflower_java.data.PlantAndGardenPlantings;

import java.util.List;

public final class GardenPlantingListViewModel extends ViewModel {

    private  LiveData<List<PlantAndGardenPlantings>> plantAndGardenPlantings;

    public final LiveData<List<PlantAndGardenPlantings>> getPlantAndGardenPlantings() {
        return plantAndGardenPlantings;
    }

    @ViewModelInject
    public GardenPlantingListViewModel(GardenPlantingRepository gardenPlantingRepository) {
        super();
        plantAndGardenPlantings = gardenPlantingRepository.getPlantAndGardenPlantings();
    }
}
