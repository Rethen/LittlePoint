package com.then.littlepoint.event;

import com.litesuits.orm.db.assit.QueryBuilder;

/**
 * Created by 42524 on 2015/12/30.
 */
public class DBEvent extends BaseEvent {



    public static final int SAVE = 1;

    public static final int SAVE_LIST = 2;

    public static final int DELETE = 3;

    public static final int DELETE_LIST = 4;

    public static final int SERCH_WITH_QB = 5;

    public static final int SERCH_ALL=6;

    private Object object;

    private  Class clazz;

    private QueryBuilder queryBuilder;


    public DBEvent(Class clazz){
        setClazz(clazz);
    }


    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }


    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public QueryBuilder getQueryBuilder() {
        return queryBuilder;
    }

    public void setQueryBuilder(QueryBuilder queryBuilder) {
        this.queryBuilder = queryBuilder;
    }
}
