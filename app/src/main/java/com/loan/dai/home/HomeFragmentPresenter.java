package com.loan.dai.home;

import com.loan.dai.base.basemodel.BaseModel;
import com.loan.dai.base.basepresenter.BasePresenter;
import com.loan.dai.http.ApiCallBack;

public class HomeFragmentPresenter extends BasePresenter<HomeFragmentView> {

    public HomeFragmentPresenter(HomeFragmentView mainView) {
        attachView(mainView);
    }

    public void getData() {

        subscribe(apiService.getData(), new ApiCallBack<BaseModel<String>>() {
            @Override
            public void onSuccess(BaseModel<String> videoBeanBaseModel) {
                mView.getData(videoBeanBaseModel);
            }
        });
    }

}
