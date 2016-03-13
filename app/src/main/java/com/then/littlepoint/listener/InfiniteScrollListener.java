package com.then.littlepoint.listener;

/**
 * Created by 42524 on 2016/3/5.
 */
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.then.littlepoint.utils.Preconditions;

/**
 * InfiniteScrollListener, which can be added to RecyclerView with addOnScrollListener
 * to detect moment when RecyclerView was scrolled to the end.
 */
public  class InfiniteScrollListener extends RecyclerView.OnScrollListener {

    private final int maxItemsPerRequest;
    private final LinearLayoutManager layoutManager;
    private ScrolledEndListener scrolledEndListener;
    private boolean isLoading;

    /**
     * Initializes InfiniteScrollListener, which can be added
     * to RecyclerView with addOnScrollListener method
     *
     * @param maxItemsPerRequest Max items to be loaded in a single request.
     * @param layoutManager LinearLayoutManager created in the Activity.
     */
    public InfiniteScrollListener(int maxItemsPerRequest, LinearLayoutManager layoutManager, ScrolledEndListener scrolledEndListener) {
        Preconditions.checkIfPositive(maxItemsPerRequest, "maxItemsPerRequest <= 0");
        Preconditions.checkNotNull(layoutManager, "layoutManager == null");
        this.maxItemsPerRequest = maxItemsPerRequest;
        this.layoutManager = layoutManager;
        this.scrolledEndListener=scrolledEndListener;
    }

    /**
     * Callback method to be invoked when the RecyclerView has been scrolled
     *
     * @param recyclerView The RecyclerView which scrolled.
     * @param dx The amount of horizontal scroll.
     * @param dy The amount of vertical scroll.
     */
    @Override public  void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if(isLoading)
            return;

        if (canLoadMoreItems()) {
            if(scrolledEndListener!=null) {
                isLoading=true;
                scrolledEndListener.onScrolledToEnd(layoutManager.findFirstVisibleItemPosition());
            }
        }
    }


    public void setLoading(boolean loading) {
        isLoading = loading;
    }

    /**
     * Refreshes RecyclerView by setting new adapter,
     * calling invalidate method and scrolling to given position
     *
     * @param view RecyclerView to be refreshed
     * @param adapter adapter with new list of items to be loaded
     * @param position position to which RecyclerView will be scrolled
     */
    protected void refreshView(RecyclerView view, RecyclerView.Adapter adapter, int position) {
        view.setAdapter(adapter);
        view.invalidate();
        view.scrollToPosition(position);
    }

    /**
     * Checks if more items can be loaded to the RecyclerView
     *
     * @return boolean Returns true if can load more items or false if not.
     */
    protected boolean canLoadMoreItems() {
        final int visibleItemsCount = layoutManager.getChildCount();
        final int totalItemsCount = layoutManager.getItemCount();
        final int pastVisibleItemsCount = layoutManager.findFirstVisibleItemPosition();
        final boolean lastItemShown = visibleItemsCount + pastVisibleItemsCount >= totalItemsCount;
        return lastItemShown && totalItemsCount >= maxItemsPerRequest;
    }

//    /**
//     * Callback method to be invoked when the RecyclerView has been scrolled to the end
//     *
//     * @param firstVisibleItemPosition Id of the first visible item on the list.
//     */
//    public abstract void onScrolledToEnd(final int firstVisibleItemPosition);


    public interface ScrolledEndListener{
       void onScrolledToEnd(final int firstVisibleItemPosition);
    }

}