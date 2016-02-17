package com.then.littlepoint.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.socks.library.KLog;

/**
 * Created by 42524 on 2015/12/29.
 */
public class ChatService extends Service {


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        KLog.d("onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
