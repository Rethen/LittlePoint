package com.then.littlepoint.data.json.factory;

import com.then.littlepoint.data.json.converter.SimpleJsonConverter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;


/**
 * Created by 42524 on 2015/12/12.
 */
public class SimpleJsonConverterFactory extends  Converter.Factory  {






    private  SimpleJsonConverterFactory(){

    }

    public  static SimpleJsonConverterFactory create(){
        return  new SimpleJsonConverterFactory();
    }


//    @Override
//    public Converter<ResponseBody, ?> fromResponseBody(Type type, Annotation[] annotations) {
//        return new SimpleJsonConverter<>();
//    }
//
//
//    @Override
//    public Converter<?, RequestBody> toRequestBody(Type type, Annotation[] annotations) {
//        return new SimpleJsonConverter<>();
//    }


    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return super.requestBodyConverter(type, annotations, retrofit);
    }


    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return super.responseBodyConverter(type, annotations, retrofit);
    }
}
