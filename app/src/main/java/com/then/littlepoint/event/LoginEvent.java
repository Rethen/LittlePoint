package com.then.littlepoint.event;

import com.then.littlepoint.event.BaseEvent;

/**
 * Created by 42524 on 2015/12/31.
 */
public class LoginEvent extends BaseEvent {

    private  String userName;
    private  String password;


    public LoginEvent(String userName,String password){
        setUserName(userName);
        setPassword(password);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
