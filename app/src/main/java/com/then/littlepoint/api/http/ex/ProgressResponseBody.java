package com.then.littlepoint.api.http.ex;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/**
 * Created by 42524 on 2016/1/28.
 */
public abstract class ProgressResponseBody extends ResponseBody {






    @Override
    public abstract MediaType contentType();

    @Override
    public abstract long contentLength();

    @Override
    public abstract BufferedSource source();
}
