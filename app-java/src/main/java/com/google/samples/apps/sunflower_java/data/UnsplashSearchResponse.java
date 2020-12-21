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
