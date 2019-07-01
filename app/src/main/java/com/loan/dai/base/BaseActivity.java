package com.loan.dai.base;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.loan.dai.R;
import com.loan.dai.base.basepresenter.BasePresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

//import butterknife.ButterKnife;
//import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P mPresenter;
    public EventBus eventBus = LoanApp.mEventBus;
//    private Unbinder unbinder;

    @Subscribe
    public void onEvent(Object event) {

    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();

        if (!EventBus.getDefault().isRegistered(this)) {
            eventBus.register(this);
        }
//        unbinder = ButterKnife.bind(this);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);



    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();

//        unbinder.unbind();
        eventBus.unregister(this);
        //页面销毁时取消presenter绑定
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

}
