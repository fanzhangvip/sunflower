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
