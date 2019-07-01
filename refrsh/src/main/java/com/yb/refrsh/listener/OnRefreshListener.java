package com.yb.refrsh.listener;

import androidx.annotation.NonNull;

import com.yb.refrsh.api.RefreshLayout;


/**
 * 刷新监听器
 */

public interface OnRefreshListener {
    void onRefresh(@NonNull RefreshLayout refreshLayout);
}
