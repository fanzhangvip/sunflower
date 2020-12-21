package com.google.samples.apps.sunflower_java.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class SunflowerPagerAdapter extends FragmentStateAdapter {

    public static final int  MY_GARDEN_PAGE_INDEX = 0;
    public static final int PLANT_LIST_PAGE_INDEX = 1;


    private Fragment[] tabFragmentsCreators = new Fragment[]{
            new Fragment(),
    };


    public SunflowerPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public SunflowerPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public SunflowerPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return tabFragmentsCreators[position];
    }

    @Override
    public int getItemCount() {
        return tabFragmentsCreators.length;
    }
}
