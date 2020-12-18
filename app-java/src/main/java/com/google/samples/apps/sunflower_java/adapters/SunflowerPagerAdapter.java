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
