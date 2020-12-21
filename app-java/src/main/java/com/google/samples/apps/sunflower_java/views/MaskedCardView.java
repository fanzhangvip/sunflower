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
