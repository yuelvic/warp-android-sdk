package com.yuelvic.warptest;

import android.content.Context;

import com.yuelvic.warptest.http.ServiceBuilder;
import com.yuelvic.warptest.http.WarpService;

import java.util.HashMap;

/**
 * Created by yuelvic on 9/2/16.
 */
public class Warp {

    protected Context context;
    protected String api_key;
    protected String master_key;
    protected String url;
    protected HashMap<String, String> headers;

    private static Warp warp;
    protected WarpService service;

    private Warp(Context context, String url) {
        this.context = context;
        this.url = url;
        headers = new HashMap<>();
        service = ServiceBuilder.createApiService(WarpService.class, this.url);
    }

    private Warp(Context context, String url, String api_key) {
        this.context = context;
        this.url = url;
        this.api_key = api_key;
        headers = new HashMap<>();
        headers.put("X-Warp-API-Key", this.api_key);
        service = ServiceBuilder.createApiService(WarpService.class, this.url);
    }

    private Warp(Context context, String url, String api_key, String master_key) {
        this.context = context;
        this.url = url;
        this.api_key = api_key;
        this.master_key = master_key;
        headers = new HashMap<>();
        headers.put("X-Warp-API-Key", this.api_key);
        headers.put("X-Warp-Master-Key", this.master_key);
        service = ServiceBuilder.createApiService(WarpService.class, this.url);
    }

    public static void initialize(Context context, String url) {
        warp = new Warp(context, url);
    }

    public static void initialize(Context context, String url, String api_key) {
        warp = new Warp(context, url, api_key);
    }

    public static void initialize(Context context, String url, String api_key, String master_key) {
        warp = new Warp(context, url, api_key, master_key);
    }

    public static Warp getInstance() {
        if (warp == null) {
            throw new NullPointerException();
        } else {
            return warp;
        }
    }

    public Context getContext() {
        return context;
    }

    public String getApiKey() {
        return this.api_key;
    }

    public HashMap<String, String> getHeaders() {
        return headers;
    }

    public WarpService getService() {
        return this.service;
    }

}
