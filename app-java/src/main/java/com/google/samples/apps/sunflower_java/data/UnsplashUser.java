package com.google.samples.apps.sunflower_java.data;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;


public final class UnsplashUser {

    @SerializedName("name")
    private String  name;

    @SerializedName("username")
    private String  username;

    @NotNull
    public final String getAttributionUrl() {
        return "https://unsplash.com/" + this.username + "?utm_source=sunflower&utm_medium=referral";
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getUsername() {
        return this.username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UnsplashUser(@NotNull String name, @NotNull String username) {
        super();
        this.name = name;
        this.username = username;
    }

}
