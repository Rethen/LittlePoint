package com.then.littlepoint.data.xml.converter;


import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;


/**
 * Created by 42524 on 2015/12/12.
 */
public class SimpleXmlConverter<T> implements Converter<ResponseBody, T> {
    @Override
    public T convert(ResponseBody value) throws IOException {
        return null;
    }
}
