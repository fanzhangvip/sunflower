package com.google.samples.apps.sunflower_java.viewmodels;


import com.google.samples.apps.sunflower_java.data.GardenPlanting;
import com.google.samples.apps.sunflower_java.data.Plant;
import com.google.samples.apps.sunflower_java.data.PlantAndGardenPlantings;

import java.text.SimpleDateFormat;
import java.util.Locale;


public final class PlantAndGardenPlantingsViewModel {
    private  Plant plant;
    private  GardenPlanting gardenPlanting;
    private  String waterDateString;
    private  String plantDateString;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.US);

    public final String getWaterDateString() {
        return waterDateString;
    }

    public final int getWateringInterval() {
        return plant.getWateringInterval();
    }

    public final String getImageUrl() {
        return plant.getImageUrl();
    }

    public final String getPlantName() {
        return plant.getName();
    }

    public final String getPlantDateString() {
        return plantDateString;
    }

    public final String getPlantId() {
        return plant.getPlantId();
    }

    public PlantAndGardenPlantingsViewModel(PlantAndGardenPlantings plantings) {
        super();
        plant = plantings.getPlant();
        gardenPlanting = plantings.getGardenPlantings().get(0);
        waterDateString = dateFormat.format(gardenPlanting.getLastWateringDate().getTime());
        plantDateString = dateFormat.format(gardenPlanting.getPlantDate().getTime());
    }


}