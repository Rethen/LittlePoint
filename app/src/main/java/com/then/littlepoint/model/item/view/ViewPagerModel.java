package com.then.littlepoint.model.item.view;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableList;
import com.then.littlepoint.BR;
import com.then.littlepoint.model.item.ModelAdapter;

import me.tatarka.bindingcollectionadapter.BindingViewPagerAdapter;
import me.tatarka.bindingcollectionadapter.ItemView;
import me.tatarka.bindingcollectionadapter.ItemViewArg;
import me.tatarka.bindingcollectionadapter.ItemViewSelector;

/**
 * Created by 42524 on 2015/12/31.
 */
public class ViewPagerModel extends ModelAdapter {

    @Bindable
    private ObservableList<Observable> items;

    @Bindable
    private   BindingViewPagerAdapter.PageTitles<Observable> pageTitles;

    @Bindable
    private ItemViewArg itemView;


    public ViewPagerModel(ObservableList<Observable> items,final  String[] titles){
        this.items=items;

        pageTitles = new BindingViewPagerAdapter.PageTitles<Observable>() {
            @Override
            public CharSequence getPageTitle(int position, Observable item) {
                return titles[position];
            }
        };

    }

    public ViewPagerModel(ObservableList<Observable> items,String[] titles,int layoutId){
        this(items,titles);
        itemView =ItemViewArg.of(ItemView.of(BR.item, layoutId));
    }

    public ViewPagerModel(ObservableList<Observable> items,String[] titles, ItemViewSelector selector) {
        this(items,titles);
        itemView = ItemViewArg.of(selector);
    }


    public ObservableList<Observable> getItems() {
        return items;
    }

    public void setItems(ObservableList<Observable> items) {
        this.items = items;
    }

    public void setPageTitles(BindingViewPagerAdapter.PageTitles<Observable> pageTitles) {
        this.pageTitles = pageTitles;
    }

    public BindingViewPagerAdapter.PageTitles<Observable> getPageTitles() {
        return pageTitles;
    }


    public ItemViewArg getItemView() {
        return itemView;
    }

    public void setItemView(ItemViewArg singleItemView) {
        this.itemView = singleItemView;
    }


}
