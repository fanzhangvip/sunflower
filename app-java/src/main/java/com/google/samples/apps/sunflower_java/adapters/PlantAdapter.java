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

package com.google.samples.apps.sunflower_java.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.google.samples.apps.sunflower_java.HomeViewPagerFragmentDirections;
import com.google.samples.apps.sunflower_java.data.Plant;
import com.google.samples.apps.sunflower_java.databinding.ListItemPlantBinding;

import java.util.Objects;

public class PlantAdapter extends ListAdapter<Plant, PlantAdapter.PlantViewHolder> {


    public PlantAdapter(@NonNull PlantDiffCallback diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public PlantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PlantViewHolder(ListItemPlantBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PlantViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    static class PlantViewHolder extends RecyclerView.ViewHolder {

        private ListItemPlantBinding binding;

        public PlantViewHolder(ListItemPlantBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.setClickListener(view -> {
                navigateToPlant(binding.getPlant(), view);
            });
        }


        private void navigateToPlant(Plant plant, View view) {
            Navigation.findNavController(view).navigate(HomeViewPagerFragmentDirections.actionViewPagerFragmentToPlantDetailFragment(plant.getPlantId()));
        }

        protected void bind(Plant item) {
            binding.setPlant(item);
            binding.executePendingBindings();
        }
    }

    public static class PlantDiffCallback extends DiffUtil.ItemCallback<Plant> {

        @Override
        public boolean areItemsTheSame(@NonNull Plant oldItem, @NonNull Plant newItem) {
            return oldItem.getPlantId() == newItem.getPlantId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Plant oldItem, @NonNull Plant newItem) {
            return Objects.equals(oldItem, newItem);
        }
    }
}
