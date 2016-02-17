package com.then.littlepoint.event;

/**
 * Created by 42524 on 2015/12/15.
 */
public class SimpleEvent extends  BaseEvent {

    private String message;

    public  SimpleEvent(int code,String message){

    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
