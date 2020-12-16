/*
 * Copyright 2019 Shawn Wang
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

package com.google.samples.apps.sunflower_java.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Calendar;
import java.util.Objects;


@Entity(tableName = "garden_plantings",
        foreignKeys = {@ForeignKey(entity = Plant.class, parentColumns = {"id"}, childColumns = {"plant_id"})},
        indices = {@Index("plant_id")})
public final class GardenPlanting {
    @ColumnInfo(name = "plant_id") private final String plantId;


    @ColumnInfo(name = "plant_date") private final Calendar plantDate;


    @ColumnInfo(name = "last_watering_date") private final Calendar lastWateringDate;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long gardenPlantingId = 0L;

    public GardenPlanting(String plantId, Calendar plantDate, Calendar lastWateringDate) {
        this.plantId = plantId;
        this.plantDate = plantDate == null ? Calendar.getInstance() : plantDate;
        this.lastWateringDate = lastWateringDate == null ? Calendar.getInstance() : lastWateringDate;
    }

    public String getPlantId() {
        return plantId;
    }

    public Calendar getPlantDate() {
        return plantDate;
    }

    public Calendar getLastWateringDate() {
        return lastWateringDate;
    }

    public long getGardenPlantingId() {
        return gardenPlantingId;
    }

    public void setGardenPlantingId(long gardenPlantingId) {
        this.gardenPlantingId = gardenPlantingId;
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("GardenPlanting(plantId=%s, plantDate=%s, lastWateringDate=%s)",
                plantId, plantDate.toString(), lastWateringDate.toString());
    }


    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        GardenPlanting target = (GardenPlanting) obj;

        return this.plantId.equals(target.plantId)
                && this.plantDate.equals(this.plantDate)
                && this.lastWateringDate.equals(this.lastWateringDate);
    }


    @Override
    public int hashCode() {
        return Objects.hash(gardenPlantingId);
    }


    @Override
    protected Object clone() {
        return new GardenPlanting(plantId, plantDate, lastWateringDate);
    }
}
