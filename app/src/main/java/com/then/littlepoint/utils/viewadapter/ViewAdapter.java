package com.then.littlepoint.utils.viewadapter;

import android.databinding.BindingAdapter;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.socks.library.KLog;
import com.then.littlepoint.R;

import codetail.graphics.drawables.LollipopDrawablesCompat;

/**
 * Created by 42524 on 2015/12/20.
 */
public class ViewAdapter {

    public static class RelativeLayoutAdapter {
        @BindingAdapter("rippleDrawbale")
        public static void bindRippleDrawale(View view, String id) {
            view.setBackground(LollipopDrawablesCompat.getDrawable(view.getResources(), R.drawable.list_selector));
        }
        //setOnRefreshListener
    }

    @BindingMethods({
            @BindingMethod(type = SwipeRefreshLayout.class, attribute = "android:refreshlistener", method = "setOnRefreshListener"),
            @BindingMethod(type = SwipeRefreshLayout.class, attribute = "android:refreshing", method = "setRefreshing")
    })
    public static class SwipeRefreshAdapter {

    }

    @BindingMethods({
            @BindingMethod(type = TabLayout.class, attribute = "android:setup", method = "setupWithViewPager"),
    })
    public static class TabLayoutAdapter {

    }

    @BindingMethods({
            @BindingMethod(type = View.class, attribute = "android:onLongClick", method = "setOnLongClickListener")})
    public static class TextViewAdapter {

    }
    @BindingMethods({@BindingMethod(type = RecyclerView.class,attribute = "android:scrollListener",method = "addOnScrollListener")})
    public  static  class  RecyclerViewAdapter{

    }


}
