package com.loan.dai.http;


import com.loan.dai.base.LoanApp;
import com.loan.dai.config.ApiConfig;
import com.loan.dai.utils.SPUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * description 统一添加header的拦截器
 */
public class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        String token = SPUtil.getString(LoanApp.mContext, ApiConfig.TOKEN);

        builder.addHeader("token", token);

        return chain.proceed(builder.build());
    }
}