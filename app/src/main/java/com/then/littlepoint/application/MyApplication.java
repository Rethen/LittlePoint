package com.then.littlepoint.application;

import android.support.multidex.MultiDexApplication;

import com.then.littlepoint.manager.AndroidCompontManager;
import com.then.littlepoint.manager.DBManager;



/**
 * Created by 42524 on 2015/12/6.
 */
public class MyApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidCompontManager.init(getApplicationContext());
        DBManager.init(getApplicationContext());
    }

}
