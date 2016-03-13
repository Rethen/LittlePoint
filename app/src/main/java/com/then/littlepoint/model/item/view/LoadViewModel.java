package com.then.littlepoint.model.item.view;

import android.databinding.Bindable;

import com.then.littlepoint.BR;
import com.then.littlepoint.model.item.ModelAdapter;

/**
 * Created by then on 2016/3/13.
 */
public class LoadViewModel extends ModelAdapter {


    @Bindable
   private boolean loading;
    public boolean isLoading() {
        return loading;

    }

    public void setLoading(boolean loading) {
        this.loading = loading;
        notifyPropertyChanged(BR.loading);
    }
}
