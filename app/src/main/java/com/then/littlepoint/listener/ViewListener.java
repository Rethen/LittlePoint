package com.then.littlepoint.listener;

import android.view.View;

import com.then.littlepoint.model.ItemAction;
import com.then.littlepoint.model.item.ModelAdapter;

/**
 * Created by 42524 on 2016/1/8.
 */
public interface ViewListener extends View.OnClickListener,View.OnLongClickListener{


    @Override
    default void onClick(View v) {
        action(v,ItemAction.ONCLICK);
    }

    @Override
    default boolean onLongClick(View v) {
        action(v, ItemAction.LONG_CLICK);
        return true;
    }

    void  action(View view,int actionType);
}
