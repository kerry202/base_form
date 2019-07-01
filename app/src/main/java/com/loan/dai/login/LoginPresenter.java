package com.loan.dai.login;

import com.loan.dai.base.basemodel.BaseModel;
import com.loan.dai.base.basepresenter.BasePresenter;
import com.loan.dai.http.ApiCallBack;

public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginPresenter(LoginView loginView) {
        attachView(loginView);
    }

    public void sendSms() {
        showLoading();
        subscribe(apiService.getData(), new ApiCallBack<BaseModel<SmSModel>>() {
            @Override
            public void onSuccess(BaseModel<SmSModel> sModelBaseModel) {
                mView.sendSmS(sModelBaseModel);
                hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                hideLoading();
            }
        });
    }

    public void sendLogin() {
        showLoading();
        subscribe(apiService.getData(), new ApiCallBack<BaseModel<LoginModel>>() {
            @Override
            public void onSuccess(BaseModel<LoginModel> loginModelBaseModel) {
                mView.sendLogin(loginModelBaseModel);
                hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                hideLoading();
            }
        });
    }
}
