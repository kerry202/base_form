package com.loan.dai.base.basepresenter;

import com.loan.dai.base.baseview.IBaseView;
import com.loan.dai.http.ApiManager;
import com.loan.dai.http.ApiService;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class BasePresenter<V extends IBaseView> implements IPresenter<V> {

    protected V mView;
    protected ApiService apiService;
    protected CompositeSubscription mCompositeSubscription;

    @Override
    public void attachView(V v) {
        this.mView = (V) v;
        apiService = ApiManager.getApiService();
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubscribe();
    }

    @Override
    public void subscribe(Observable observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }

        //绑定observable与subscriber
        Subscription subscription = observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(subscriber);

        mCompositeSubscription.add(subscription);
    }

    @Override
    public void unSubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    protected void showLoading() {
        mView.showLoading();
    }

    protected void hideLoading() {
        mView.hideLoading();
    }
}
