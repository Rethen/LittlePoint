package com.then.littlepoint.model.item.data;

import android.content.Intent;
import android.databinding.Bindable;
import android.view.View;


import com.litesuits.orm.db.annotation.Ignore;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;
import com.then.littlepoint.BR;
import com.then.littlepoint.R;
import com.then.littlepoint.activity.TowActivity;
import com.then.littlepoint.event.AndroidCompontEvent;
import com.then.littlepoint.manager.AndroidCompontManager;
import com.then.littlepoint.model.item.ModelAdapter;

import java.util.HashMap;
import java.util.Map;

import de.greenrobot.event.EventBus;


/**
 * Created by 42524 on 2015/9/6.
 */
@Table("people")
public class People extends ModelAdapter {

    @PrimaryKey(value = AssignType.AUTO_INCREMENT)
    private long id;// id

    @Bindable
    protected String url;

    @Bindable
    protected String title="then";

    @Bindable
    @Ignore
    protected String color="#673AB7";



    public String getTitle() {
        return title;
    }


    public String getUrl() {
        return url;
    }

    public People(String title, String url,int viewType) {
        this.title = title;
        this.url = url;
        this.viewType=viewType;
    }
    public People(String title, String url) {
        this.title = title;
        this.url = url;
    }
    public People(){

    }



    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTitle(String title) {
        this.title = title;
//        notifyPropertyChanged(BR.title);
    }



    @Override
    public void action(View view) {
        int viewId=view.getId();
        switch (viewId){
            case R.id.title:
                setTitle("11111");
                break;
            case R.id.item_root:
                Student student=new Student("then",18);
                Intent intent= AndroidCompontManager.getInstance().newIntent(TowActivity.class);
                intent.putExtra("stu",student);
                AndroidCompontEvent compontEvent=new AndroidCompontEvent(AndroidCompontEvent.TYPE_ACTIVITY,intent);
                EventBus.getDefault().post(compontEvent);
                break;
        }
    }
}
