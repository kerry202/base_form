package com.loan.dai.http;


import com.loan.dai.base.basemodel.BaseModel;
import com.loan.dai.logs.Logs;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * description 自定义请求数据回调和过滤
 */
public abstract class ApiCallBack<M extends BaseModel> extends Subscriber<M> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        Logs.s("   requst onError " + e.getMessage());
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            int code = httpException.code();
            if (code >= 400 && code < 500) {

            } else if (code >= 500) {

            }
        }

    }

    @Override
    public void onNext(M baseModel) {
        onSuccess(baseModel);
        Logs.s("   requst onNext " + baseModel.message);
    }

    public abstract void onSuccess(M m);

}