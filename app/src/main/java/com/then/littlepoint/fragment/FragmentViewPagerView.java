package com.then.littlepoint.fragment;

import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.then.littlepoint.BR;
import com.then.littlepoint.R;
import com.then.littlepoint.api.http.HttpService;
import com.then.littlepoint.databinding.ViewpagerViewBinding;
import com.then.littlepoint.listener.LoadAndRefreshListener;
import com.then.littlepoint.manager.HttpApiManager;
import com.then.littlepoint.model.helper.ModelHelper;
import com.then.littlepoint.model.item.ModelAdapter;
import com.then.littlepoint.model.item.data.People;
import com.then.littlepoint.model.item.data.Student;
import com.then.littlepoint.model.item.data.User;
import com.then.littlepoint.model.item.view.ListViewModel;
import com.then.littlepoint.model.item.view.LoadViewModel;
import com.then.littlepoint.model.item.view.ViewPagerModel;

import me.tatarka.bindingcollectionadapter.ItemView;
import me.tatarka.bindingcollectionadapter.ItemViewSelector;
import me.tatarka.bindingcollectionadapter.LayoutManagers;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by evan on 5/31/15.
 */
public class FragmentViewPagerView extends BaseFragment implements LoadAndRefreshListener {


    private static final String TAG = "BindingViewPager";
    private ListViewModel viewModel;
    private ViewpagerViewBinding binding;
    ObservableList<Observable> mItems = new ObservableArrayList<>();
    private String[] titles = new String[]{"1", "235566468", "gfhgfhhgfhgfhgffhg", "ghgdfhtyfhtyhg", "lkfjhlkfjdglkjg", "123"};

    ListViewModel listViewModel;

    ObservableList<Observable> items;
    ObservableList<Observable> items1;
    ObservableList<Observable> items2;
    ObservableList<Observable> items3;
    ObservableList<Observable> items4;
    ObservableList<Observable> itmes5;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        items = new ObservableArrayList<>();

        for (int i = 0; i < 3; i++) {
            items.add(new People("你好", "https://www.baidu.com/img/bdlogo.png", 1));
        }

        items1 = new ObservableArrayList<>();
        for (int i = 0; i < 3; i++) {
            items1.add(new Student("zhuanglizhong", 20));
        }

        items2 = new ObservableArrayList<>();
        for (int i = 0; i < 3; i++) {
            items2.add(new Student("zhuanglizhong", 20));
        }


        items3 = new ObservableArrayList<>();
        for (int i = 0; i < 3; i++) {
            items3.add(new Student("zhuanglizhong", 20));
        }


        items4 = new ObservableArrayList<>();
        for (int i = 0; i < 10; i++) {
            items4.add(new Student("zhuanglizhong", 20));
        }
        LoadViewModel loadViewModel=new LoadViewModel();
        loadViewModel.setViewType(3);
        items4.add(loadViewModel);

        itmes5 = new ObservableArrayList<>();

        for (int i = 0; i < 3; i++) {
            itmes5.add(new Student("zhuanglizhong", 20));
        }

        mItems.add(new ListViewModel(items, R.layout.item_peo,(LinearLayoutManager) LayoutManagers.linear().create(getContext())));

        mItems.add(new ListViewModel(items1, R.layout.item_stu,(LinearLayoutManager) LayoutManagers.linear().create(getContext())));

        mItems.add(new ListViewModel(items2, R.layout.item_stu,(LinearLayoutManager) LayoutManagers.linear().create(getContext())));

        mItems.add(new ListViewModel(items3, R.layout.item_stu,(LinearLayoutManager) LayoutManagers.linear().create(getContext())));



        ItemViewSelector selector = new ItemViewSelector<ModelAdapter>() {
            @Override
            public void select(ItemView itemView, int position, ModelAdapter item) {
                if (item.getViewType() == 0) {
                    itemView.set(BR.item, R.layout.item_stu);
                } else if (item.getViewType() == 3) {
                    itemView.set(BR.item, R.layout.load_view);
                }

        }
            @Override
            public int viewTypeCount() {
                return 2;
            }

            @Override
            public void bind(LayoutInflater inflater, @LayoutRes int layoutId, ViewGroup viewGroup) {

            }
        };


        listViewModel = new ListViewModel(items4, selector,(LinearLayoutManager) LayoutManagers.linear().create(getContext()));
ModelHelper modelHelper=new ModelHelper();
        modelHelper.setUrl(HttpService.LOGIN);
        listViewModel.setModelHelper(modelHelper);
        listViewModel.setLayoutManager((LinearLayoutManager) LayoutManagers.linear().create(getContext()));
        listViewModel.setLoadAndRefreshListener(this);
        mItems.add(listViewModel);

// mItems.add(new ListViewModel(itmes5, R.layout.item_stu1));
        mItems.add(new Student("zlz", 2, 5));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = ViewpagerViewBinding.inflate(inflater, container, false);

        ItemViewSelector selector = new ItemViewSelector<ModelAdapter>() {
            @Override
            public void select(ItemView itemView, int position, ModelAdapter item) {
                if (item.getViewType() == 1) {
                    itemView.set(BR.item, R.layout.viewpager_item);
                } else if (item.getViewType() == 3) {
                    itemView.set(BR.item, R.layout.viewpager_item);
                } else if (item.getViewType() == 5) {
                    itemView.set(BR.item, R.layout.item_stu);
                } else {
                    itemView.set(BR.item, R.layout.viewpager_item);
                }

            }

            @Override
            public int viewTypeCount() {
                return 2;
            }

            @Override
            public void bind(LayoutInflater inflater, @LayoutRes int layoutId, ViewGroup viewGroup) {

            }
        };
        ViewPagerModel viewPagerModel = new ViewPagerModel(mItems, titles, selector);
        binding.setViewModel(viewPagerModel);
        binding.executePendingBindings();
        binding.pager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (!(position > 3)) {
                    binding.rfabGroupSampleRfabg.setSection(position);
                } else {

                }
            }
        });
        binding.pager.setOffscreenPageLimit(titles.length);
        binding.tab.setupWithViewPager(binding.pager);
        return binding.getRoot();
    }

    /**
     * 上拉加载数据
     *
     * @param modelHelper
     */
    @Override
    public void load(ModelHelper modelHelper) {
        switch (modelHelper.getUrl()) {
            case HttpService.LOGIN:
                rx.Observable<User> callLogin = HttpApiManager.getInstance().getService(HttpService.class).login();
                callLogin.subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(listViewModel);
                break;
        }
    }

    /**
     * 下拉刷新数据
     *
     * @param modelHelper
     */
    @Override
    public void refresh(ModelHelper modelHelper) {
        switch (modelHelper.getUrl()) {
            case HttpService.LOGIN:
                rx.Observable<User> callLogin = HttpApiManager.getInstance().getService(HttpService.class).login();
                callLogin.subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(listViewModel);
                break;
        }
    }
}
