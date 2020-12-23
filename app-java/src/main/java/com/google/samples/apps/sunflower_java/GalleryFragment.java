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
import androidx.navigation.Navigation;

import com.google.samples.apps.sunflower_java.adapters.GalleryAdapter;
import com.google.samples.apps.sunflower_java.databinding.FragmentGalleryBinding;
import com.google.samples.apps.sunflower_java.viewmodels.GalleryViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class GalleryFragment extends Fragment {

    private GalleryAdapter adapter = new GalleryAdapter(new GalleryAdapter.GalleryDiffCallback());
    private GalleryViewModel viewModel;

    private GalleryFragmentArgs args;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        args = GalleryFragmentArgs.fromBundle(getArguments());
        viewModel = new ViewModelProvider(this).get(GalleryViewModel.class);
        FragmentGalleryBinding binding = FragmentGalleryBinding.inflate(inflater, container, false);
        if(getContext() !=null){
            return binding.getRoot();
        }
        binding.photoList.setAdapter(adapter);
        search(args.getPlantName());
        binding.toolbar.setNavigationOnClickListener(view -> {
            Navigation.findNavController(view).navigateUp();
        });

        return binding.getRoot();
    }

    private void search(String query) {
        viewModel.searchPictures(query).observe(getViewLifecycleOwner(), unsplashPhotos -> {
//            adapter.submitData(unsplashPhotos);
        });
    }
}
