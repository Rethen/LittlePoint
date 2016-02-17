package com.then.littlepoint.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.socks.library.KLog;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;


public class ImageLoadAdapter {

    @BindingAdapter({"bind:imageUrl"})
    public static void bindImage(ImageView view, String url) {
        KLog.d("bind:imageUrl");
        Glide.with(view.getContext()).load(url).bitmapTransform(new BlurTransformation(view.getContext(),2),new CropCircleTransformation(view.getContext())).into(view);
    }
}
