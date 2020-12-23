package com.google.samples.apps.sunflower_java;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager2.widget.ViewPager2;

import com.google.samples.apps.sunflower_java.adapters.GardenPlantingAdapter;
import com.google.samples.apps.sunflower_java.data.GardenPlanting;
import com.google.samples.apps.sunflower_java.data.PlantAndGardenPlantings;
import com.google.samples.apps.sunflower_java.databinding.FragmentGardenBinding;
import com.google.samples.apps.sunflower_java.viewmodels.GardenPlantingListViewModel;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

import static com.google.samples.apps.sunflower_java.adapters.SunflowerPagerAdapter.PLANT_LIST_PAGE_INDEX;


@AndroidEntryPoint
public class GardenFragment extends Fragment {

    private FragmentGardenBinding binding;
    private GardenPlantingListViewModel viewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        viewModel = new ViewModelProvider(this).get(GardenPlantingListViewModel.class);

        binding = FragmentGardenBinding.inflate(inflater,container,false);
        GardenPlantingAdapter adapter = new GardenPlantingAdapter(new GardenPlantingAdapter.GardenPlantDiffCallback());

        binding.gardenList.setAdapter(adapter);
        binding.addPlant.setOnClickListener(view -> navigateToPlantListPage());

        subscribeUi(adapter,binding);

        return binding.getRoot();
    }

    private void subscribeUi(GardenPlantingAdapter adapter, FragmentGardenBinding binding){
        viewModel.getPlantAndGardenPlantings().observe(getViewLifecycleOwner(), gardenPlantings -> {
            binding.setHasPlantings(!gardenPlantings.isEmpty());
            adapter.submitList(gardenPlantings);
        });
    }

    private void navigateToPlantListPage(){
        ViewPager2 viewPager2 = requireActivity().findViewById(R.id.view_pager);
        viewPager2.setCurrentItem(PLANT_LIST_PAGE_INDEX);
    }
}
