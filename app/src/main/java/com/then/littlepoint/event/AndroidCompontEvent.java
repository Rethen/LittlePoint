package com.then.littlepoint.event;

import android.content.Intent;
import android.view.View;

import java.util.Map;

/**
 * Created by 42524 on 2015/12/22.
 */
public class AndroidCompontEvent extends BaseEvent {

    public static final int TYPE_ACTIVITY = 1;

    public static final int TYPE_SERVICE = 2;

    public static final int TYPE_BORADCAST = 3;

    private Class clazz;


    private Intent intent;


    public AndroidCompontEvent(){

    }


    public AndroidCompontEvent(int code,Class clazz) {
        setClazz(clazz);
    }



    public AndroidCompontEvent(int code,Intent intent) {
        setCode(code);
        setIntent(intent);
    }


    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }



    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public Intent getIntent() {
        return intent;
    }


}
