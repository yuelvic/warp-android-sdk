package com.yuelvic.warptest;

import com.yuelvic.warptest.http.ServiceBuilder;
import com.yuelvic.warptest.http.WarpService;

/**
 * Created by yuelvic on 9/2/16.
 */
public class Warp {

    protected String api_key;
    protected String master_key;
    protected String url;

    private static Warp warp;
    protected WarpService service;

    private Warp(String url) {
        this.url = url;
        service = ServiceBuilder.createApiService(WarpService.class, this.url);
    }

    private Warp(String url, String api_key) {
        this.url = url;
        this.api_key = api_key;
        service = ServiceBuilder.createApiService(WarpService.class, this.url);
    }

    private Warp(String url, String api_key, String master_key) {
        this.url = url;
        this.api_key = api_key;
        this.master_key = master_key;
        service = ServiceBuilder.createApiService(WarpService.class, this.url);
    }

    public static void initialize(String url) {
        warp = new Warp(url);
    }

    public static void initialize(String url, String api_key) {
        warp = new Warp(url, api_key);
    }

    public static void initialize(String url, String api_key, String master_key) {
        warp = new Warp(url, api_key, master_key);
    }

    public static Warp getInstance() {
        if (warp == null) {
            throw new NullPointerException();
        } else {
            return warp;
        }
    }

    public String getApiKey() {
        return this.api_key;
    }

    public WarpService getService() {
        return this.service;
    }

}
