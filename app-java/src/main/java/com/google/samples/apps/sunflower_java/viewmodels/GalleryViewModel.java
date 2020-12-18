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

package com.google.samples.apps.sunflower_java.viewmodels;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.ViewModel;
import androidx.paging.CachedPagingDataKt;

import com.google.samples.apps.sunflower_java.data.UnsplashRepository;

import org.jetbrains.annotations.NotNull;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

public class  GalleryViewModel extends ViewModel {
    private String currentQueryValue;
    private Flow currentSearchResult;
    private final UnsplashRepository repository;

    @NotNull
    public final Flow searchPictures(String queryString) {
        this.currentQueryValue = queryString;
        Flow newResult = null;
        this.currentSearchResult = newResult;
        return newResult;
    }

    @ViewModelInject
    public GalleryViewModel(UnsplashRepository repository) {
        super();
        this.repository = repository;
    }
}
