package com.then.littlepoint.event;

/**
 * Created by 42524 on 2016/1/21.
 */
public class UploadAndDownLoadEvent extends BaseEvent {

    public static final int ING = 0;
    public static final int FILED = -1;
    public static final int SUCCESS = 1;

    private  long  loaded;
    private  long  total;

    public UploadAndDownLoadEvent() {
    }

    public UploadAndDownLoadEvent(long loaded, long total) {
        this.loaded = loaded;
        this.total = total;
    }

    public UploadAndDownLoadEvent(long loaded, long total,int code) {
      this(loaded, total);
        setCode(code);
    }

    public UploadAndDownLoadEvent(int code) {
        setCode(code);
    }






    public long getLoaded() {
        return loaded;
    }

    public void setLoaded(long loaded) {
        this.loaded = loaded;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
