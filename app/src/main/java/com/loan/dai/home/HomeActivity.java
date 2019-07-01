package com.loan.dai.home;


import android.os.Bundle;

import com.loan.dai.R;
import com.loan.dai.base.BaseActivity;
import com.loan.dai.base.basemodel.BaseModel;

import org.greenrobot.eventbus.Subscribe;

public class HomeActivity extends BaseActivity<HomePresenter> implements HomeView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);

        mPresenter.getData();


    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter(this);
    }


    @Override
    public void getData(BaseModel<String> date) {
        
    }

    @Subscribe
    public void onEvent(Object event) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
