package com.then.littlepoint.model.item.data;

import android.databinding.Bindable;
import android.support.design.widget.TabLayout;
import android.view.View;

import com.then.littlepoint.BR;
import com.then.littlepoint.model.item.view.ViewPagerModel;

/**
 * Created by 42524 on 2016/1/18.
 */
public class People1 extends People {


    @Bindable
    private String ex="fgfdgd";

    @Bindable
    private ViewPagerModel viewPagerModel;


//    public final TabLayout tab;


    public People1(){
        super();
    }

    public People1(String title, String url, int pageType) {
        super(title, url, pageType);
    }

    public String getEx() {
        return ex;
    }


    public ViewPagerModel getViewPagerModel() {
        return viewPagerModel;
    }

    public void setViewPagerModel(ViewPagerModel viewPagerModel) {
        this.viewPagerModel = viewPagerModel;
        notifyPropertyChanged(BR.viewPagerModel);
    }

    public void setEx(String ex) {
        this.ex = ex;
        notifyPropertyChanged(BR.title);
    }
}
