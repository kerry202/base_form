package com.loan.dai.home;

import com.loan.dai.R;
import com.loan.dai.base.BaseFragment;
import com.loan.dai.base.basemodel.BaseModel;

public class HomeFragment extends BaseFragment<HomeFragmentPresenter> implements HomeFragmentView {


    @Override
    protected HomeFragmentPresenter createPresenter() {
        return new HomeFragmentPresenter(this);
    }

    @Override
    public int getRootViewId() {
        return R.layout.fragment_home_layout;
    }

    @Override
    public void initUI() {

    }

    @Override
    public void initData() {
        mPresenter.getData();

    }


    @Override
    public void getData(BaseModel<String> date) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
