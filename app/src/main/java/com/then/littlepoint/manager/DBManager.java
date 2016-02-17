package com.then.littlepoint.manager;

import android.content.Context;

import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.DataBase;
import com.socks.library.KLog;
import com.then.littlepoint.event.DBEvent;
import com.then.littlepoint.event.result.DBResult;

import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * Created by 42524 on 2015/12/30.
 */
public class DBManager {

    public static final String DB_NAME = "test.db";

    private static DBManager dbManager;

    private DataBase db;

    public static void init(Context context) {
        if (dbManager == null)
            syncInit(context);
    }

    private static synchronized void syncInit(Context context) {
        if (dbManager == null)
            dbManager = new DBManager(context);
    }

    private DBManager(Context context) {
        db = LiteOrm.newSingleInstance(context, DB_NAME);
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.Async)
    public void exeutDB(DBEvent dbEvent) {
        DBResult result = new DBResult(dbEvent.getClazz());
        result.setCode(dbEvent.getCode());
        switch (dbEvent.getCode()) {
            case DBEvent.DELETE:
                db.delete(dbEvent.getObject());
                break;
            case DBEvent.DELETE_LIST:
                db.delete((List)dbEvent.getObject());
                break;
            case DBEvent.SAVE:
                db.save(dbEvent.getObject());
                break;
            case DBEvent.SAVE_LIST:
                db.save((List)dbEvent.getObject());
                break;
            case DBEvent.SERCH_ALL:
                db.query(dbEvent.getClazz());
                break;

            case DBEvent.SERCH_WITH_QB:
                db.query(dbEvent.getQueryBuilder());
                break;
        }
        result.setStatus(DBResult.SUCCESS);
        EventBus.getDefault().post(result);
    }
}


