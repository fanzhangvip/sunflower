package com.google.samples.apps.sunflower_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ShareCompat;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.samples.apps.sunflower_java.data.Plant;
import com.google.samples.apps.sunflower_java.databinding.FragmentPlantDetailBinding;
import com.google.samples.apps.sunflower_java.viewmodels.PlantDetailViewModel;

import java.util.concurrent.atomic.AtomicBoolean;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

import static com.google.samples.apps.sunflower_java.viewmodels.PlantDetailViewModel.*;


@AndroidEntryPoint
public class PlantDetailFragment extends Fragment {


    private PlantDetailFragmentArgs args;
    FragmentPlantDetailBinding binding;


    @Inject
    AssistedFactory plantDetailViewModelFactory;

    private  PlantDetailViewModel  plantDetailViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        args = PlantDetailFragmentArgs.fromBundle(getArguments());
        plantDetailViewModel = PlantDetailViewModel.provideFactory(plantDetailViewModelFactory,args.getPlantId()).create(PlantDetailViewModel.class);
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_plant_detail,container,false);

        binding.setViewModel(plantDetailViewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.setCallback(plant -> {
            hideAppBarFab(binding.fab);
            plantDetailViewModel.addPlantToGarden();
            Snackbar.make(binding.getRoot(), R.string.added_plant_to_garden, Snackbar.LENGTH_LONG)
                    .show();
        });

        binding.galleryNav.setOnClickListener(view -> navigateToGallery());

        AtomicBoolean isToolbarShown = new AtomicBoolean(false);
        binding.plantDetailScrollview.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener) (scrollView, scrollX, scrollY, oldX, oldY) ->{
            boolean shouldShowToolbar = scrollY > binding.toolbar.getHeight();
            if(isToolbarShown.get() != shouldShowToolbar){
                isToolbarShown.set(shouldShowToolbar);
                binding.appbar.setActivated(shouldShowToolbar);
                binding.toolbarLayout.setTitleEnabled(shouldShowToolbar);
            }
        });

        binding.toolbar.setNavigationOnClickListener(view -> Navigation.findNavController(view).navigateUp());

        binding.toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()){
                case R.id.action_share:
                    createShareIntent();
                    return true;
            }
            return false;
        });

        setHasOptionsMenu(true);

        return binding.getRoot();
    }

    private void navigateToGallery() {

        plantDetailViewModel.getPlant().observe(getViewLifecycleOwner(),plant -> {
            Navigation.findNavController(binding.galleryNav).navigate(PlantDetailFragmentDirections.actionPlantDetailFragmentToGalleryFragment(plant.getName()));
        });
    }


    private void createShareIntent() {
        String shareText = "";
        Plant plant = plantDetailViewModel.getPlant().getValue();
        if( plant!= null){
            shareText = getString(R.string.share_text_plant,plant.getName());
        }
        Intent shareIntent = ShareCompat.IntentBuilder.from(requireActivity())
                .setText(shareText)
                .setType("text/plain")
                .createChooserIntent()
                .addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        startActivity(shareIntent);
    }


    private void hideAppBarFab(FloatingActionButton fab) {
        CoordinatorLayout.LayoutParams params =  (CoordinatorLayout.LayoutParams)fab.getLayoutParams();
        FloatingActionButton.Behavior behavior = (FloatingActionButton.Behavior)params.getBehavior();
        behavior.setAutoHideEnabled(false);
        fab.hide();
    }


    public interface Callback {
        void add(Plant plant);
    }
}
