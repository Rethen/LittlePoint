package com.then.littlepoint.fragment;

import android.support.v4.app.Fragment;
import android.view.View;

import com.then.littlepoint.listener.ViewListener;
import com.then.littlepoint.model.item.ModelAdapter;

/**
 * Created by 42524 on 2016/2/18.
 */
public class BaseFragment extends Fragment implements ModelAdapter.ViewModelListner {


    @Override
    public void actionViewModel(View view, ModelAdapter modelAdapter,int actionType) {

    }
}
