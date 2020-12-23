package com.google.samples.apps.sunflower_java;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.samples.apps.sunflower_java.databinding.ActivityGardenBinding;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class GardenActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this,R.layout.activity_garden);
    }
}
