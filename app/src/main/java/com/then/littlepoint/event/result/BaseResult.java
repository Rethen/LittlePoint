package com.then.littlepoint.event.result;

/**
 * Created by 42524 on 2015/12/30.
 */
public class BaseResult {

    /**
     * 请求码
     */
    protected int code;

    /**
     * 状态码
     */
    protected  int status;

    public  static  final  int  SUCCESS=1;

    public  static  final  int FAILD=-1;


    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }


    public int getCode() {
        return code;
    }


    public void setCode(int code) {
        this.code = code;
    }
}
