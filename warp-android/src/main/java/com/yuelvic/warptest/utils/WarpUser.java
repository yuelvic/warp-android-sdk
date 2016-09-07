package com.yuelvic.warptest.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.yuelvic.warptest.Warp;
import com.yuelvic.warptest.http.WarpCallback;

import java.util.HashMap;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yuelvic on 9/6/16.
 */
public class WarpUser {

    private static Warp warp;
    static {
        warp = Warp.getInstance();
    }

    private String username;
    private String password;
    private String email;
    private HashMap<String, Object> map;

    public static void login(String username, String password, final WarpCallback callback) {
        warp.getService().login(warp.getHeaders(), username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WarpUser>() {
                    @Override
                    public void onCompleted() {
                        callback.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e);
                    }

                    @Override
                    public void onNext(WarpUser user) {
                        SharedPreferences preferences = warp.getContext().getSharedPreferences("warp", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("warp-user", new Gson().toJson(user));
                        editor.apply();
                    }
                });
    }

    public static WarpUser getCurrentUser() {
        SharedPreferences preferences = warp.getContext().getSharedPreferences("warp", Context.MODE_PRIVATE);
        return new Gson().fromJson(preferences.getString("warp-user", ""), WarpUser.class);
    }

}
