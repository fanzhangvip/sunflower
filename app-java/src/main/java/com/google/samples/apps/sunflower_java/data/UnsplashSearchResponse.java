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

package com.google.samples.apps.sunflower_java.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class UnsplashSearchResponse {
    @SerializedName("results")
    private  List results;
    @SerializedName("total_pages")
    private  int totalPages;

    public final List getResults() {
        return this.results;
    }

    public final int getTotalPages() {
        return this.totalPages;
    }

    public void setResults(List results) {
        this.results = results;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public UnsplashSearchResponse(List results, int totalPages) {
        super();
        this.results = results;
        this.totalPages = totalPages;
    }
}
