package com.google.samples.apps.sunflower_java.data;

import androidx.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PlantRepository {
    private PlantDao plantDao;

    @Inject
    public PlantRepository(PlantDao gardenPlantingDao) {
        this.plantDao = gardenPlantingDao;
    }

    public LiveData<List<Plant>> getPlants() {
        return this.plantDao.getPlants();
    }

    public LiveData<Plant> getPlant(String plantId) {
        return this.plantDao.getPlant(plantId);
    }

    public LiveData<List<Plant>> getPlantsWithGrowZoneNumber(int growZoneNumber) {
        return this.plantDao.getPlantsWithGrowZoneNumber(growZoneNumber);
    }
}
