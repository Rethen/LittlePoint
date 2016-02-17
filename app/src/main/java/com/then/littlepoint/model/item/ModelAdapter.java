package com.then.littlepoint.model.item;

import android.databinding.BaseObservable;
import android.view.View;

import com.socks.library.KLog;
import com.then.littlepoint.manager.AndroidCompontManager;
import com.then.littlepoint.model.ItemAction;


/**
 * Created by 42524 on 2015/12/15.
 */
public  abstract class ModelAdapter extends  BaseObservable  implements  ItemAction {


    protected int viewType;

    public ModelAdapter(){

    }

    @Override
    public void onClick(View v) {
        action(v);
    }


    public void action(View view) {

    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
