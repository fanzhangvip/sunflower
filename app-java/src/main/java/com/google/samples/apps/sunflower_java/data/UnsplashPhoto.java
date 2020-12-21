package com.google.samples.apps.sunflower_java.data;

import com.google.gson.annotations.SerializedName;


public class UnsplashPhoto {
    @SerializedName("id")
    private String id;

    @SerializedName("urls")
    private UnsplashPhotoUrls urls;

    @SerializedName("user")
    private UnsplashUser user;

    public void setId(String id) {
        this.id = id;
    }

    public void setUrls(UnsplashPhotoUrls urls) {
        this.urls = urls;
    }

    public void setUser(UnsplashUser user) {
        this.user = user;
    }

    public final String getId() {
        return this.id;
    }

    public final UnsplashPhotoUrls getUrls() {
        return this.urls;
    }

    public final UnsplashUser getUser() {
        return this.user;
    }

    public UnsplashPhoto( String id, UnsplashPhotoUrls urls, UnsplashUser user) {
        super();
        this.id = id;
        this.urls = urls;
        this.user = user;
    }
}
