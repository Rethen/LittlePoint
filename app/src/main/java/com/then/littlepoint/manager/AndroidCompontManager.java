package com.then.littlepoint.manager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.then.littlepoint.event.AndroidCompontEvent;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;


/**
 * Created by 42524 on 2015/12/21.
 */

public class AndroidCompontManager {

    private static AndroidCompontManager androidCompontManager;

    private Context context;

    public static void init(Context context) {
        if (androidCompontManager == null)
            syncInit(context);
    }

    public static AndroidCompontManager getInstance() {
        return androidCompontManager;
    }


    private static synchronized void syncInit(Context context) {
        if (androidCompontManager == null)
            androidCompontManager = new AndroidCompontManager(context);
    }


    public void setContext(Context context) {
        if (context != null)
            this.context = context;
    }

    private AndroidCompontManager(Context context) {
        this.context = context;
        EventBus.getDefault().register(this);
    }

    public Intent newIntent(Class clazz) {
        return new Intent(context, clazz);
    }

    public Intent newIntent(String actionName) {
        return new Intent(actionName);
    }

    public Intent newIntent(String actionName, Uri uri) {
        return new Intent(actionName, uri);
    }


    @Subscribe(threadMode = ThreadMode.MainThread)
    public void startCompont(AndroidCompontEvent androidCompontEvent) {
        Intent intent = null;
        if (androidCompontEvent.getIntent() == null) {
            intent = new Intent(context, androidCompontEvent.getClazz());
        } else {
            intent = androidCompontEvent.getIntent();
        }
        switch (androidCompontEvent.getCode()) {
            case AndroidCompontEvent.TYPE_ACTIVITY:
//                TransitionManager.getDefault(context).setFrom(androidCompontEvent.getViewMap(),intent).launch(intent);
//                ActivityTransitionLauncher.with(context).putFromAll(androidCompontEvent.getViewMap()).launch(intent);
                startActivity(intent);
                break;

            case AndroidCompontEvent.TYPE_SERVICE:
                startService(intent);
                break;

            case AndroidCompontEvent.TYPE_BORADCAST:
                startBordeCast(intent);
                break;

        }
    }

    private void startActivity(Intent intent) {
        context.startActivity(intent);
    }

    private void startService(Intent intent) {
        context.startService(intent);
    }

    private void startBordeCast(Intent intent) {
        context.sendBroadcast(intent);
    }


}
