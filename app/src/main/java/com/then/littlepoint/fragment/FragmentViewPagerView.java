package com.then.littlepoint.fragment;

import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.then.littlepoint.R;
import com.then.littlepoint.databinding.ItemPeo1Binding;
import com.then.littlepoint.databinding.ViewpagerViewBinding;
import com.then.littlepoint.model.item.data.People;
import com.then.littlepoint.model.item.data.Student;
import com.then.littlepoint.model.item.view.ListViewModel;
import com.then.littlepoint.model.item.view.ViewPagerModel;



/**
 * Created by evan on 5/31/15.
 */
public class FragmentViewPagerView extends Fragment  {


    private static final String TAG = "BindingViewPager";
    private ListViewModel viewModel;
    private ViewpagerViewBinding binding;
    ObservableList<Observable> mItems = new ObservableArrayList<>();
    private String[] titles = new String[]{"1", "235566468", "gfhgfhhgfhgfhgffhg", "ghgdfhtyfhtyhg","lkfjhlkfjdglkjg"};
    ObservableList<Observable> items1;
    ObservableList<Observable> items2;
    ObservableList<Observable> items3;
    ObservableList<Observable> items4;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);


        final ObservableList<Observable> items = new ObservableArrayList<>();
        for (int i = 0; i < 3; i++) {
            items.add(new People("你好", "https://www.baidu.com/img/bdlogo.png"));
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
        for (int i = 0; i < 3; i++) {
            items4.add(new Student("zhuanglizhong", 20));
        }

        mItems.add(new ListViewModel(items, R.layout.item_peo));

        mItems.add(new ListViewModel(items1, R.layout.item_stu));

        mItems.add(new ListViewModel(items2, R.layout.item_stu));

        mItems.add(new ListViewModel(items3, R.layout.item_stu));

        mItems.add(new ListViewModel(items4, R.layout.item_stu));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = ViewpagerViewBinding.inflate(inflater, container, false);


        ViewPagerModel viewPagerModel = new ViewPagerModel(mItems,titles, R.layout.viewpager_item );
        binding.setViewModel(viewPagerModel);
        binding.executePendingBindings();
        binding.pager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
             @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                    if(!(position>3)) {
                        binding.rfabGroupSampleRfabg.setSection(position);
                    }
                    else {

                    }
            }
        });
        binding.pager.setOffscreenPageLimit(titles.length);
        binding.tab.setupWithViewPager(binding.pager);
        return binding.getRoot();
    }

}
