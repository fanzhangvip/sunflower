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
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.google.samples.apps.sunflower_java.HomeViewPagerFragmentDirections;
import com.google.samples.apps.sunflower_java.R;
import com.google.samples.apps.sunflower_java.data.PlantAndGardenPlantings;
import com.google.samples.apps.sunflower_java.databinding.ListItemGardenPlantingBinding;
import com.google.samples.apps.sunflower_java.viewmodels.PlantAndGardenPlantingsViewModel;

import java.util.Objects;

public class GardenPlantingAdapter extends ListAdapter<PlantAndGardenPlantings, GardenPlantingAdapter.ViewHolder> {

    protected GardenPlantingAdapter(@NonNull GardenPlantDiffCallback diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item_garden_planting,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private ListItemGardenPlantingBinding binding;

        public ViewHolder(@NonNull ListItemGardenPlantingBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.setClickListener(view ->{
                navigateToPlant(binding.getViewModel().getPlantId(),view);
            });
        }

        private void navigateToPlant(String plantId, View view){
            Navigation.findNavController(view).navigate(HomeViewPagerFragmentDirections.actionViewPagerFragmentToPlantDetailFragment(plantId));
        }

        protected void bind(PlantAndGardenPlantings plantings){
            binding.setViewModel(new PlantAndGardenPlantingsViewModel(plantings));
            binding.executePendingBindings();
        }
    }

    static class GardenPlantDiffCallback extends DiffUtil.ItemCallback<PlantAndGardenPlantings>{

        @Override
        public boolean areItemsTheSame(@NonNull PlantAndGardenPlantings oldItem, @NonNull PlantAndGardenPlantings newItem) {
            return oldItem.getPlant().getPlantId() == newItem.getPlant().getPlantId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull PlantAndGardenPlantings oldItem, @NonNull PlantAndGardenPlantings newItem) {
            return Objects.equals(oldItem.getPlant(),newItem.getPlant());
        }
    }
}
