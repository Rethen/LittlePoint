package com.then.littlepoint.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;


public class ImageLoadAdapter {

    @BindingAdapter("imageUrl")
    public static void bindImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).bitmapTransform(new BlurTransformation(view.getContext(), 2), new CropCircleTransformation(view.getContext())).into(view);
    }

    @BindingAdapter({"imageUrl","isCircle"})
    public static void bindImage(ImageView view, String url, boolean f) {
        if (f) {
            Glide.with(view.getContext()).load(url).bitmapTransform(new BlurTransformation(view.getContext(), 2), new CropCircleTransformation(view.getContext())).into(view);
        } else {
            Glide.with(view.getContext()).load(url).bitmapTransform(new BlurTransformation(view.getContext(), 2)).into(view);
        }
    }
}
