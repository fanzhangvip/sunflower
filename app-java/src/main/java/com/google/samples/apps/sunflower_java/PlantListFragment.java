package com.google.samples.apps.sunflower_java;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.samples.apps.sunflower_java.adapters.PlantAdapter;
import com.google.samples.apps.sunflower_java.databinding.FragmentPlantListBinding;
import com.google.samples.apps.sunflower_java.viewmodels.PlantListViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class PlantListFragment extends Fragment {

    private PlantListViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentPlantListBinding binding = FragmentPlantListBinding.inflate(inflater, container, false);
        if(getContext() != null){
            return binding.getRoot();
        }

        PlantAdapter adapter = new PlantAdapter(new PlantAdapter.PlantDiffCallback());
        binding.plantList.setAdapter(adapter);
        subscribeUi(adapter);

        setHasOptionsMenu(true);

        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
       inflater.inflate(R.menu.menu_plant_list,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.filter_zone){
            updateData();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void subscribeUi(PlantAdapter adapter) {
        viewModel.plants.observe(getViewLifecycleOwner(),plants -> adapter.submitList(plants));
    }

    private void updateData() {
        if(viewModel.isFiltered()){
            viewModel.setGrowZoneNumber(9);
        }else {
            viewModel.clearGrowZoneNumber();
        }
    }
}
