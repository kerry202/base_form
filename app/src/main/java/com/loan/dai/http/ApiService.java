package com.loan.dai.http;


import com.loan.dai.base.basemodel.BaseModel;
import com.loan.dai.config.ApiConfig;

import java.util.HashMap;

import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import rx.Observable;
import rx.Observer;

import static com.loan.dai.config.ApiConfig.isDebug;

/**
 * description Retrofit interface
 */
public interface ApiService {

    String SERVER_ADDRESS_RELEASE = ApiConfig.Base_Url;
    String SERVER_ADDRESS_DEBUG = ApiConfig.Base_Url;
    String SERVER_ADDRESS = isDebug ? SERVER_ADDRESS_DEBUG : SERVER_ADDRESS_RELEASE;

    @GET(ApiConfig.bloom)
    Observable<BaseModel<String>> getData();

    @FormUrlEncoded
    @POST(ApiConfig.SendSms)
    Observer<String> sendSmd(@Field("mobile") String phone, @Field("type") String type);

    @FormUrlEncoded
    @POST(ApiConfig.SendSms)
    Observable<String> getPost(@FieldMap HashMap<String, String> fields);

    @FormUrlEncoded
    @PUT(ApiConfig.SendSms)
    Observable<String> getPut(@FieldMap HashMap<String, String> fields);


}
