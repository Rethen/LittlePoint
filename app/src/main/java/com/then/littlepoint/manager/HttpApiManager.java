package com.then.littlepoint.manager;

import com.then.littlepoint.data.json.factory.SimpleJsonConverterFactory;
import com.then.littlepoint.model.item.data.People;

import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;


/**
 * Created by 42524 on 2015/12/12.
 */
public class HttpApiManager {


    public static final String SCHEME = "http";
    public static final String BASE_URL = "192.168.103.156";
    public static final int PORT = 8080;
    private static HttpApiManager httpApiManager;

    private Retrofit retrofit;

    private HttpUrl httpUrl;

    public static HttpApiManager getInstance() {
        if (httpApiManager == null)
            syncInit();
        return httpApiManager;
    }

    private static synchronized void syncInit() {
        if (httpApiManager == null)
            httpApiManager = new HttpApiManager();
    }

    private HttpApiManager() {
        httpUrl = new HttpUrl.Builder().scheme(SCHEME).host(BASE_URL).port(PORT).build();
        retrofit = createNewRetrofit(GsonConverterFactory.create(), httpUrl);
    }

    private Retrofit createNewRetrofit(Converter.Factory factory, HttpUrl httpUrl) {
        OkHttpClient okHttpClient=new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(120, TimeUnit.SECONDS).build();
        return new Retrofit.Builder()
                .baseUrl(httpUrl)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(factory)
                .build();
    }

    public <T> T getService(Class<T> clazz) {
        return retrofit.create(clazz);
    }

    public <T> T getService(Class<T> clazz, Converter.Factory factory) {
        Retrofit retrofit = createNewRetrofit(factory, httpUrl);
        return retrofit.create(clazz);
    }

    public <T> T getService(Class<T> clazz, Converter.Factory factory, HttpUrl httpUrl) {
        Retrofit retrofit = createNewRetrofit(factory, httpUrl);
        return retrofit.create(clazz);
    }


}
