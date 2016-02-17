package me.tatarka.bindingcollectionadapter.factories;

import android.support.v7.widget.RecyclerView;
import me.tatarka.bindingcollectionadapter.BindingCollectionAdapter;
import me.tatarka.bindingcollectionadapter.BindingRecyclerViewAdapter;
import me.tatarka.bindingcollectionadapter.ItemViewArg;

public interface BindingRecyclerViewAdapterFactory {
    <T> BindingCollectionAdapter<T> create(RecyclerView recyclerView, ItemViewArg<T> arg);

    BindingRecyclerViewAdapterFactory DEFAULT = new BindingRecyclerViewAdapterFactory() {
        @Override
        public <T> BindingCollectionAdapter<T> create(RecyclerView recyclerView, ItemViewArg<T> arg) {
            return new BindingRecyclerViewAdapter<>(arg);
        }
    };
}
