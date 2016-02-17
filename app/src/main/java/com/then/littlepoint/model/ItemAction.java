package com.then.littlepoint.model;

import android.databinding.BaseObservable;
import android.view.View;


/**
 * Created by 42524 on 2015/12/15.
 */
public interface ItemAction extends View.OnClickListener{


    void action(View view);
}
