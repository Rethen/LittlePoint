package com.then.littlepoint.listener;

import android.view.View;

import com.then.littlepoint.model.ItemAction;
import com.then.littlepoint.model.item.ModelAdapter;

/**
 * Created by 42524 on 2016/1/8.
 */
public interface ViewListener extends View.OnClickListener,View.OnLongClickListener{




    void  action(View view,int actionType);
}
