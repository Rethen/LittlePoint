package com.then.littlepoint.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.socks.library.KLog;
import com.then.littlepoint.R;
import com.then.littlepoint.event.DBEvent;
import com.then.littlepoint.event.result.DBResult;
import com.then.littlepoint.model.item.data.People;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * Created by 42524 on 2015/12/28.
 */
public class TowActivity extends BaseActivity {



    Map<String ,View> viewMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_tow);


        DBEvent dbEvent=new DBEvent(People.class);
        dbEvent.setObject(new People());

        dbEvent.setCode(DBEvent.SAVE);
        EventBus.getDefault().post(dbEvent);
    }

    @Subscribe(threadMode = ThreadMode.MainThread)
    public void dbResult(DBResult result) {
        if (result.getClazz().getName().equals(People.class.getName())) {
            //数据库操作成功
            if(result.getStatus()==DBResult.SUCCESS){
                switch (result.getCode()){
                    case DBEvent.SAVE:
                        Toast.makeText(getApplicationContext(),"插入成功",Toast.LENGTH_LONG).show();
                        break;
                    case DBEvent.SAVE_LIST:
                        Toast.makeText(getApplicationContext(),"批量插入成功",Toast.LENGTH_LONG).show();
                        break;
                }
            }
            //数据库操作失败
            else {

            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

}
