package com.then.littlepoint.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.socks.library.KLog;
import com.then.littlepoint.BR;
import com.then.littlepoint.R;
import com.then.littlepoint.api.http.HttpService;
import com.then.littlepoint.api.http.ex.ProgressRequestBody;
import com.then.littlepoint.databinding.ItemPeo1Binding;
import com.then.littlepoint.databinding.ListViewBinding;
import com.then.littlepoint.event.UploadAndDownLoadEvent;
import com.then.littlepoint.manager.HttpApiManager;
import com.then.littlepoint.model.item.ModelAdapter;
import com.then.littlepoint.model.item.data.People;
import com.then.littlepoint.model.item.data.People1;
import com.then.littlepoint.model.item.data.Student;
import com.then.littlepoint.model.item.data.User;
import com.then.littlepoint.model.item.view.ListViewModel;
import com.then.littlepoint.model.item.view.ViewPagerModel;


import java.io.File;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;
import me.tatarka.bindingcollectionadapter.ItemView;
import me.tatarka.bindingcollectionadapter.ItemViewSelector;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by evan on 5/31/15.
 */
public class FragmentListView extends Fragment {

    private static final String TAG = "BindingList";
    private ListViewModel viewModel;
    public ObservableList<Observable> items;

    private String[] titles = new String[]{"1ghghgjhgjhgj","dgfdgdfgdfg"};


    private ObservableList<Observable> stuListItems;

    ObservableList<Observable> items2;
    ObservableList<Observable> items3;

    ObservableList<Observable> mItems = new ObservableArrayList<>();

    private String urls[] = new String[]{"http://avatar.csdn.net/5/B/B/1_lizzy115.jpg", "http://avatar.csdn.net/E/9/A/1_yetaodiao.jpg", "http://avatar.csdn.net/C/A/6/1_dragon_cheng.jpg", "http://avatar.csdn.net/E/2/F/1_happy09li.jpg"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
        items = new ObservableArrayList<>();

        stuListItems = new ObservableArrayList<>();

        for (int i = 0; i < 100; i++) {
            stuListItems.add(new People("你好" + i, "http://www.baidu.com/img/bd_logo1.png", 1));
        }

//        items2 = new ObservableArrayList<>();
//        for (int i = 0; i < 15; i++) {
//            items2.add(new People("你好" + i, "http://www.baidu.com/img/bd_logo1.png", 1));
//        }
//
//        items3 = new ObservableArrayList<>();
//        for (int i = 0; i < 15; i++) {
//            items3.add(new People("你好" + i, "http://www.baidu.com/img/bd_logo1.png", 1));
//        }

//        mItems.add(new ListViewModel(items2, R.layout.item_peo));
//        mItems.add(new ListViewModel(items3, R.layout.item_peo));
//
//        ViewPagerModel viewPagerModel = new ViewPagerModel(mItems, titles, R.layout.viewpager_item);
//
//
//        ListViewModel listViewModel = new ListViewModel(stuListItems, R.layout.item_peo);

        for (int i = 0; i < 10000; i++) {
            if (i % 2 == 0)
                items.add(new People("你好" + i, "http://www.baidu.com/img/bd_logo1.png", 1));
            else if (i % 3 == 0) {
                Student student = new Student("people2" + i, 0, 3);
//                student.setViewModel(listViewModel);
                items.add(student);
            } else {
                People1 people1 = new People1("你好" + i, "http://www.baidu.com/img/bd_logo1.png", 2);
//                people1.setViewPagerModel(viewPagerModel);
                items.add(people1);
            }
        }
        ItemViewSelector selector = new ItemViewSelector<ModelAdapter>() {
            @Override
            public void select(ItemView itemView, int position, ModelAdapter item) {
                if (item.getViewType() == 1) {
                    itemView.set(BR.item, R.layout.item_peo);
                } else if (item.getViewType() == 2) {
                    itemView.set(BR.item, R.layout.item_peo1);
                } else if (item.getViewType() == 3) {
                    itemView.set(BR.item, R.layout.item_stu);
                }

            }

            @Override
            public int viewTypeCount() {
                return 3;
            }

            @Override
            public void bind(LayoutInflater inflater, @LayoutRes int layoutId, ViewGroup viewGroup) {
                if (layoutId == R.layout.item_peo1) {

                }
            }
        };

        viewModel = new ListViewModel(items, selector);


//        ItemPeo1Binding binding=   ItemPeo1Binding.inflate(getLayoutInflater(savedInstanceState));
//
//        binding.executePendingBindings();
//        binding.tab.setupWithViewPager(binding.pager);
//
//
//       KLog.d("count:"+binding.pager.getAdapter().getCount());

//        rx.Observable<User> call = HttpApiManager.getInstance().getService(UserHttpService.class).getUser("then");
//        call.subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(user -> test(user)
//                );

        rx.Observable<Student> callLogin = HttpApiManager.getInstance().getService(HttpService.class).getTest();
        callLogin.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Student>() {
                               @Override
                               public void onCompleted() {

                               }

                               @Override
                               public void onError(Throwable e) {

                               }

                               @Override
                               public void onNext(Student student) {

                               }
                           }
                );


        File file = new File("/sdcard/1.apk");
        File file1 = new File("/sdcard/2.apk");

        RequestBody requestBody = new  ProgressRequestBody(file);
        RequestBody requestBody1 = new ProgressRequestBody(file1);

        RequestBody item = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("mFile", "1.txt", requestBody).build();
        rx.Observable<Void> call = HttpApiManager.getInstance().getService(HttpService.class).upload(item);
        call.subscribeOn(Schedulers.newThread()).subscribe(new Subscriber<Void>() {
            @Override
            public void onCompleted() {
                KLog.d("onCompleted:item");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(Void aVoid) {

            }
        });


        RequestBody item1 = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("mFile", "1.txt", requestBody1).build();
        rx.Observable<Void> call1 = HttpApiManager.getInstance().getService(HttpService.class).upload(item1);
        call1.subscribeOn(Schedulers.newThread()).subscribe(new Subscriber<Void>() {
            @Override
            public void onCompleted() {
                KLog.d("onCompleted:item1");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(Void aVoid) {

            }
        });


        rx.Observable<ResponseBody> c = HttpApiManager.getInstance().getService(HttpService.class).getApk("1.apk");
        c.subscribeOn(Schedulers.newThread()).subscribe(new Subscriber<ResponseBody>() {
            @Override
            public void onCompleted() {
                KLog.d("onCompleted:down");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ResponseBody responseBody) {

            }
        });


    }

    public void test(User user) {
//           ((People) items.get(0)).setTitle(user.getUrl());
//        startActivityForResult();
    }


    public void changetime() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (Observable p : items) {
                    ((People) p).setTitle("100");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Subscribe(threadMode = ThreadMode.MainThread)
    public void fileProgress(UploadAndDownLoadEvent event) {
        KLog.d("event:" + event.getLoaded());
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ListViewBinding binding = ListViewBinding.inflate(inflater, container, false);
        binding.setViewModel(viewModel);
        binding.executePendingBindings();
        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
