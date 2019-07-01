package com.loan.dai.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.loan.dai.base.basepresenter.BasePresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

//import butterknife.ButterKnife;
//import butterknife.Unbinder;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    public EventBus eventBus = LoanApp.mEventBus;
//    private Unbinder unbinder;
    protected P mPresenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getRootViewId(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = createPresenter();
        if (!EventBus.getDefault().isRegistered(this)) {
            eventBus.register(this);
        }
//        unbinder = ButterKnife.bind(this, view);

        initUI();
        initData();
    }

    protected abstract P createPresenter();


    public abstract int getRootViewId();

    public abstract void initUI();

    public abstract void initData();
    @Subscribe
    public void onEvent(Object event) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        unbinder.unbind();
        eventBus.unregister(this);
    }
}
