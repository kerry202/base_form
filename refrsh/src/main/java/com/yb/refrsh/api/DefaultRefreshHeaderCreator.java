package com.yb.refrsh.api;

import android.content.Context;

import androidx.annotation.NonNull;

/**
 * 默认Header创建器
 */
public interface DefaultRefreshHeaderCreator {
    @NonNull
    RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout);
}
