package com.then.littlepoint.model.item.data;

import android.databinding.Bindable;


import com.litesuits.orm.db.annotation.Ignore;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;
import com.then.littlepoint.BR;
import com.then.littlepoint.model.item.ModelAdapter;


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
    protected String title = "then";

    @Bindable
    @Ignore
    protected String color = "#673AB7";

    @Bindable
    private  boolean type;


    public String getTitle() {
        return title;
    }


    public String getUrl() {
        return url;
    }

    public People(String title, String url, int viewType) {
        this.title = title;
        this.url = url;
        this.viewType = viewType;
    }

    public People(String title, String url, int viewType,ViewModelListner viewModelListner) {
        this(title, url, viewType);
        this.viewModelListner=viewModelListner;
    }


    public People() {

    }

    public void setType(boolean type) {
        this.type = type;
        notifyPropertyChanged(BR.type);
    }

    public boolean isType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }


}
