package com.then.littlepoint.model.item;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.socks.library.KLog;
import com.then.littlepoint.listener.ViewListener;
import com.then.littlepoint.manager.AndroidCompontManager;
import com.then.littlepoint.model.ItemAction;


/**
 * Created by 42524 on 2015/12/15.
 */
public  abstract class ModelAdapter extends  BaseObservable implements  ViewListener {


    protected int viewType;

    @Bindable
    protected ViewModelListner viewModelListner;


    public ModelAdapter(){

    }

    public ModelAdapter(ViewModelListner viewModelListner){
        this.viewModelListner=viewModelListner;
    }

    @Override
    public void action(View view,int actionType) {
           if(viewModelListner!=null)
               viewModelListner.actionViewModel(view, this,actionType);
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }


    public void setViewModelListner(ViewModelListner viewModelListner) {
        this.viewModelListner = viewModelListner;
    }


    public ViewModelListner getViewModelListner() {
        return viewModelListner;
    }

    public  interface   ViewModelListner{
        void actionViewModel(View view, ModelAdapter modelAdapter,int actionType);
    }

}
