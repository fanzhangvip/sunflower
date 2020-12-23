package com.google.samples.apps.sunflower_java;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayoutMediator;
import com.google.samples.apps.sunflower_java.adapters.SunflowerPagerAdapter;
import com.google.samples.apps.sunflower_java.databinding.FragmentViewPagerBinding;

import dagger.hilt.android.AndroidEntryPoint;

import static com.google.samples.apps.sunflower_java.adapters.SunflowerPagerAdapter.MY_GARDEN_PAGE_INDEX;
import static com.google.samples.apps.sunflower_java.adapters.SunflowerPagerAdapter.PLANT_LIST_PAGE_INDEX;


@AndroidEntryPoint
public class HomeViewPagerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentViewPagerBinding binding = FragmentViewPagerBinding.inflate(inflater, container, false);

        binding.viewPager.setAdapter(new SunflowerPagerAdapter(this));

        new TabLayoutMediator(binding.tabs,binding.viewPager, (tab, position) -> {
            tab.setIcon(getTabIcon(position));
            tab.setText(getTabTitle(position));
        });

        ((AppCompatActivity)requireActivity()).setSupportActionBar(binding.toolbar);

        return binding.getRoot();
    }

    private int getTabIcon(int position) {
        int result = R.drawable.garden_tab_selector;
        switch (position) {
            case MY_GARDEN_PAGE_INDEX:
                result = R.drawable.garden_tab_selector;
            break;
            case PLANT_LIST_PAGE_INDEX:
                result = R.drawable.plant_list_tab_selector;
            break;
        }
        return result;
    }

    private String getTabTitle(int position){
        String result =  getString(R.string.my_garden_title);
        switch (position){
            case PLANT_LIST_PAGE_INDEX:
                result = getString(R.string.plant_list_title);
                break;
            default: result = getString(R.string.my_garden_title);
        }
        return result;
    }
}
