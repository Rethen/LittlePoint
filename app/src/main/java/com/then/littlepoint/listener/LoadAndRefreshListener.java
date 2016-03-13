package com.then.littlepoint.listener;

import com.then.littlepoint.model.helper.ModelHelper;

/**
 * Created by 42524 on 2016/3/6.
 */
public interface LoadAndRefreshListener {

    void load(ModelHelper modelHelper);

    void refresh(ModelHelper modelHelper);
}
