package com.google.samples.apps.sunflower_java.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.google.samples.apps.sunflower_java.BuildConfig;
import com.google.samples.apps.sunflower_java.data.GardenPlanting;
import com.google.samples.apps.sunflower_java.data.GardenPlantingRepository;
import com.google.samples.apps.sunflower_java.data.Plant;
import com.google.samples.apps.sunflower_java.data.PlantRepository;
import com.google.samples.apps.sunflower_java.utilities.AppExecutors;
import com.squareup.inject.assisted.Assisted;
import com.squareup.inject.assisted.AssistedInject;

public final class PlantDetailViewModel extends ViewModel {
    private  LiveData<Boolean> isPlanted;
    private  LiveData<Plant> plant;

    private GardenPlantingRepository gardenPlantingRepository;
    private  String plantId;

    public final LiveData<Boolean> isPlanted() {
        return isPlanted;
    }

    public final LiveData<Plant> getPlant() {
        return plant;
    }

    public final void addPlantToGarden() {
        AppExecutors.getInstance().diskIO().execute(() -> gardenPlantingRepository.createGardenPlanting(plantId));
    }

    public final boolean hasValidUnsplashKey() {
        return BuildConfig.UNSPLASH_ACCESS_KEY != "null";
    }

    @AssistedInject
    public PlantDetailViewModel( PlantRepository plantRepository,  GardenPlantingRepository gardenPlantingRepository, @Assisted String plantId) {
        super();
        this.gardenPlantingRepository = gardenPlantingRepository;
        this.plantId = plantId;
        LiveData<GardenPlanting> gardenPlantingForPlant = gardenPlantingRepository.getGardenPlantingForPlant(plantId);
        isPlanted = Transformations.map(gardenPlantingForPlant, it -> it != null);
        plant = plantRepository.getPlant(plantId);
    }


    @AssistedInject.Factory
    public interface AssistedFactory {
        PlantDetailViewModel create( String plantId);
    }

    public static ViewModelProvider.Factory provideFactory(AssistedFactory assistedFactory, String plantId){
        return new ViewModelProvider.Factory() {

            @Override
            public <T extends ViewModel> T create(Class<T> modelClass) {
                return (T) assistedFactory.create(plantId);
            }
        };
    }


}
