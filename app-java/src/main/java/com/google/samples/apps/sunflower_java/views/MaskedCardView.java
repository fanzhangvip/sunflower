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

package com.google.samples.apps.sunflower_java.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;


import kotlin.jvm.internal.Intrinsics;


public final class MaskedCardView extends MaterialCardView {

    private  ShapeAppearancePathProvider pathProvider;
    private  Path path;
    private  ShapeAppearanceModel shapeAppearance;
    private  RectF rectF;

    public MaskedCardView(Context context) {
        this(context,null);
    }

    public MaskedCardView(Context context, AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public MaskedCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        pathProvider = new ShapeAppearancePathProvider();
        path = new Path();
        shapeAppearance = new ShapeAppearanceModel();
        rectF = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    }


    protected void onDraw(Canvas canvas) {
        canvas.clipPath(path);
        super.onDraw(canvas);
    }

    @SuppressLint({"RestrictedApi"})
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        rectF.right = (float)w;
        rectF.bottom = (float)h;
        pathProvider.calculatePath(shapeAppearance, 1.0F, rectF, path);
        super.onSizeChanged(w, h, oldw, oldh);
    }


}
