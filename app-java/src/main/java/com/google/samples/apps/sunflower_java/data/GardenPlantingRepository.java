package com.google.samples.apps.sunflower_java.data;

import androidx.lifecycle.LiveData;


import com.google.samples.apps.sunflower_java.utilities.AppExecutors;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class GardenPlantingRepository {
    private GardenPlantingDao gardenPlantingDao;

    @Inject
    public GardenPlantingRepository(GardenPlantingDao gardenPlantingDao) {
        this.gardenPlantingDao = gardenPlantingDao;
    }

    public void createGardenPlanting(String plantId) {
        AppExecutors.getInstance().diskIO().execute(() ->
                gardenPlantingDao.insertGardenPlanting(new GardenPlanting(plantId, null, null)));
    }

    public void removeGardenPlanting(GardenPlanting gardenPlanting) {
        AppExecutors.getInstance().diskIO().execute(() ->
                gardenPlantingDao.deleteGardenPlanting(gardenPlanting));
    }

    public LiveData<GardenPlanting> getGardenPlantingForPlant(String plantId) {
        return gardenPlantingDao.getGardenPlantingForPlant(plantId);
    }

    public LiveData<List<GardenPlanting>> getGardenPlantings() {
        return gardenPlantingDao.getGardenPlantings();
    }

    public LiveData<List<PlantAndGardenPlantings>> getPlantAndGardenPlantings() {
        return gardenPlantingDao.getPlantAndGardenPlantings();
    }
}
