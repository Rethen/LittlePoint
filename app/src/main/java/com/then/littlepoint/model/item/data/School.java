package com.then.littlepoint.model.item.data;

import android.databinding.Bindable;

import com.then.littlepoint.model.item.ModelAdapter;

/**
 * Created by 42524 on 2016/2/18.
 */
public class School extends ModelAdapter {

    @Bindable
    private  String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
