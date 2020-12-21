package com.google.samples.apps.sunflower_java.data;

import com.google.gson.annotations.SerializedName;


public class UnsplashPhotoUrls {
    @SerializedName("small")
    private String small;

    public final String getSmall() {
        return this.small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public UnsplashPhotoUrls(String small) {
        super();
        this.small = small;
    }
}
