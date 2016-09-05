package com.yuelvic.warptest.http;

import com.yuelvic.warptest.utils.WarpResult;

/**
 * Created by yuelvic on 9/2/16.
 */
public interface WarpCallback {

    void onCompleted();
    void onError(Throwable e);
    void onSuccess(WarpResult result);

}
