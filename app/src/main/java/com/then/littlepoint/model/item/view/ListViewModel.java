package com.then.littlepoint.model.item.view;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableList;
import android.support.v4.widget.SwipeRefreshLayout;

import com.socks.library.KLog;
import com.then.littlepoint.BR;
import com.then.littlepoint.model.item.ModelAdapter;
import com.then.littlepoint.model.item.data.People;
import com.then.littlepoint.model.item.data.Student;

import me.tatarka.bindingcollectionadapter.BindingListViewAdapter;
import me.tatarka.bindingcollectionadapter.ItemView;
import me.tatarka.bindingcollectionadapter.ItemViewArg;
import me.tatarka.bindingcollectionadapter.ItemViewSelector;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by evan on 5/31/15.
 */
public class ListViewModel extends ModelAdapter implements SwipeRefreshLayout.OnRefreshListener {


    @Bindable
    private ObservableList<Observable> items;

    @Bindable
    private ItemViewArg itemView;

    @Bindable
    private boolean refreshing;


    public ListViewModel(ObservableList<Observable> items, int layoutId) {
        itemView = ItemViewArg.of(ItemView.of(BR.item, layoutId));
        this.items = items;
    }


    public ListViewModel(ObservableList<Observable> items, ItemViewSelector selector) {
        itemView = ItemViewArg.of(selector);
        this.items = items;
    }


    public void setRefreshing(boolean refreshing) {
        this.refreshing = refreshing;
        notifyPropertyChanged(BR.refreshing);
    }

    public void setItems(ObservableList<Observable> items) {
        this.items = items;
    }

    public ObservableList<Observable> getItems() {
        return items;
    }

    public boolean isRefreshing() {
        return refreshing;
    }

    public ItemViewArg getItemView() {
        return itemView;
    }


    public final BindingListViewAdapter.ItemIds<Observable> itemIds = new BindingListViewAdapter.ItemIds<Observable>() {
        @Override
        public long getItemId(int position, Observable item) {
            return position;
        }
    };
    @Override
    public void onRefresh() {
        rx.Observable.create(new rx.Observable.OnSubscribe<Observable>() {
            @Override
            public void call(Subscriber<? super Observable> subscriber) {
                try {
                    for (int i = 0; i < 5; i++) {
                        Thread.sleep(1000);
                        subscriber.onNext(new Student("hello" + i, 20));
                    }
                    subscriber.onCompleted();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(
                new Subscriber<Observable>() {
                    @Override
                    public void onCompleted() {
                        setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Observable observable) {
                        items.add(observable);
                    }
                });

    }


    public interface LoadAndRefreshListener {
        void load();

        void refresh();
    }
}
