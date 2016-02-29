package com.then.littlepoint.api.http;

import com.then.littlepoint.api.http.ex.ProgressRequestBody;
import com.then.littlepoint.model.item.data.Student;
import com.then.littlepoint.model.item.data.User;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import rx.Observable;

/**
 * Created by 42524 on 2015/12/11.
 */
public interface HttpService {




    public  static  final  String GET_USER="/users/{username}";

    public  static  final  String LOGIN="/login";

    public  static  final  String UPLOAD="/upload";

    public  static  final  String  GET_APK="/static/apk/{apkname}";


    @GET(GET_USER)
    Observable<User> getUser(@Path("username") String username);

    @GET(LOGIN)
    Observable<Student> login();


    @POST(UPLOAD)
    Observable<Void>  upload(@Body RequestBody body);


    @GET(GET_APK)
    @Streaming
    Observable<ResponseBody> getApk(@Path("apkname") String apkName);






}
