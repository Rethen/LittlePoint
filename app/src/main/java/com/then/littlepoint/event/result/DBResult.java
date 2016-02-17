package com.then.littlepoint.event.result;

/**
 * Created by 42524 on 2015/12/30.
 */
public class DBResult extends  BaseResult {

    private Class clazz;

    private Object object;

    public DBResult(Class clazz){
       setClazz(clazz);
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }
}
