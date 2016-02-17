package com.then.littlepoint.listener;

import android.view.View;

/**
 * Created by 42524 on 2016/1/8.
 */
public interface ViewListener extends View.OnClickListener,View.OnLongClickListener{

    @Override
    default void onClick(View v) {
        action(v);
    }

    @Override
    default boolean onLongClick(View v) {
        action(v);
        return true;
    }

    void  action(View view);
}
