package com.then.littlepoint.model.item.view;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableList;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.then.littlepoint.BR;
import com.then.littlepoint.listener.InfiniteScrollListener;
import com.then.littlepoint.listener.LoadAndRefreshListener;
import com.then.littlepoint.model.helper.ModelHelper;
import com.then.littlepoint.model.item.ModelAdapter;

import me.tatarka.bindingcollectionadapter.BindingListViewAdapter;
import me.tatarka.bindingcollectionadapter.ItemView;
import me.tatarka.bindingcollectionadapter.ItemViewArg;
import me.tatarka.bindingcollectionadapter.ItemViewSelector;
import rx.Observer;

/**
 * Created by evan on 5/31/15.
 */
public class ListViewModel extends ModelAdapter implements SwipeRefreshLayout.OnRefreshListener,InfiniteScrollListener.ScrolledEndListener, Observer<ModelAdapter> {


    /**
     * 列表数据
     */
    @Bindable
    private ObservableList<Observable> items;

    /**
     * 列表子项布局
     */
    @Bindable
    private ItemViewArg itemView;

    /**
     * 是否正在刷新
     */
    @Bindable
    private boolean refreshing;


    /**
     * 是否正在加载
     */
    @Bindable boolean loading;


    /**
     * RecyclerView的布局管理器
     */
    @Bindable
    private LinearLayoutManager layoutManager;

    /**
     * 上拉监听
     */
    @Bindable
    private InfiniteScrollListener onScrollListener;

    private ModelHelper modelHelper;

    private LoadAndRefreshListener loadAndRefreshListener;

    public ListViewModel(ObservableList<Observable> items, int layoutId) {
        itemView = ItemViewArg.of(ItemView.of(BR.item, layoutId));
        this.items = items;
    }

    public ListViewModel(ObservableList<Observable> items, int layoutId,LinearLayoutManager layoutManager) {
        itemView = ItemViewArg.of(ItemView.of(BR.item, layoutId));
        this.items = items;
        this.layoutManager=layoutManager;
        onScrollListener=new InfiniteScrollListener(5,layoutManager,this);
    }


    public ListViewModel(ObservableList<Observable> items, ItemViewSelector selector) {
        itemView = ItemViewArg.of(selector);
        this.items = items;
    }

    public ListViewModel(ObservableList<Observable> items, ItemViewSelector selector,LinearLayoutManager layoutManager) {
        itemView = ItemViewArg.of(selector);
        this.items = items;
        this.layoutManager=layoutManager;
        onScrollListener=new InfiniteScrollListener(5,layoutManager,this);
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



    public void setModelHelper(ModelHelper modelHelper) {
        this.modelHelper = modelHelper;
    }


    public ModelHelper getModelHelper() {
        return modelHelper;
    }



    public RecyclerView.OnScrollListener getOnScrollListener() {
        return onScrollListener;
    }




    public void setLoadAndRefreshListener(LoadAndRefreshListener loadAndRefreshListener) {
        this.loadAndRefreshListener = loadAndRefreshListener;
    }


    public void setLayoutManager(LinearLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
        onScrollListener=new InfiniteScrollListener(5,layoutManager,this);
    }


    public RecyclerView.LayoutManager getLayoutManager() {
        return layoutManager;
    }

    @Override
    public void onRefresh() {
        loadAndRefreshListener.refresh(modelHelper);
    }


    @Override
    public void onScrolledToEnd(int firstVisibleItemPosition) {
        changeLoadStatus(true);
        loadAndRefreshListener.load(modelHelper);
    }



    @Override
    public void onError(Throwable e) {
        onScrollListener.setLoading(false);
        changeLoadStatus(false);
        setRefreshing(false);
    }

    @Override
    public void onCompleted() {
        onScrollListener.setLoading(false);
        changeLoadStatus(false);
        setRefreshing(false);
    }

    @Override
    public void onNext(ModelAdapter o) {
        items.add(o);
    }

   private  void changeLoadStatus(boolean loading){
       if(items.get(items.size()-1) instanceof LoadViewModel ){
           LoadViewModel loadViewModel= (LoadViewModel) items.get(items.size()-1);
           loadViewModel.setLoading(loading);
       }
   }



}
