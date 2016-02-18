package com.then.littlepoint.data.json.converter;

import com.socks.library.KLog;
import com.then.littlepoint.model.item.data.Student;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;


/**
 * Created by 42524 on 2015/12/12.
 */
public class SimpleJsonConverter<T> implements Converter<ResponseBody, T> {

    @Override
    public T convert(ResponseBody value) throws IOException {
        KLog.d(value.string());
       return null;
    }
}
