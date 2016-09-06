package com.yuelvic.warptest.utils;

import com.yuelvic.warptest.Warp;
import com.yuelvic.warptest.http.WarpCallback;

import java.util.HashMap;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yuelvic on 9/2/16.
 */
public class WarpObject {

    private Warp warp;
    private String className;
    private HashMap<String, String> header;
    private HashMap<String, Object> body;

    public static class Builder {
        private String className;
        private WarpObject object;
        private HashMap<String, String> header;
        private HashMap<String, Object> body;

        public Builder() {
            header = new HashMap<>();
            body = new HashMap<>();
        }

        public Builder setClassName(String className) {
            this.className = className;
            return this;
        }

        public Builder addHeader(String key, String value) {
            this.header.put(key, value);
            return this;
        }

        public Builder addPointer(String key, String className, int id) {
            this.body.put(key, new WarpPointer(className, id));
            return this;
        }

        public Builder put(String key, Object value) {
            this.body.put(key, value);
            return this;
        }

        public WarpObject save(WarpCallback callback) {
            object = create();
            object.save(callback);
            return object;
        }

        public WarpObject save(int id, WarpCallback callback) {
            object = create();
            object.save(id, callback);
            return object;
        }

        public WarpObject find(WarpCallback callback) {
            object = create();
            object.find(callback);
            return object;
        }

        public WarpObject destroy(WarpCallback callback) {
            object = create();
            return object;
        }

        public WarpObject create() {
            return new WarpObject(this);
        }
    }

    private WarpObject(Builder builder) {
        this.className = builder.className;
        this.header = builder.header;
        this.body = builder.body;
        this.warp = Warp.getInstance();
        this.header.put("X-Warp-API-Key", warp.getApiKey());
    }

    public void save(final WarpCallback callback) {
        warp.getService().insert(className, header, body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WarpResult>() {
                    @Override
                    public void onCompleted() {
                        callback.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e);
                    }

                    @Override
                    public void onNext(WarpResult result) {
                        callback.onSuccess(result);
                    }
                });
    }

    public void save(int id, final WarpCallback callback) {
        warp.getService().update(className, header, id, body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WarpResult>() {
                    @Override
                    public void onCompleted() {
                        callback.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e);
                    }

                    @Override
                    public void onNext(WarpResult result) {
                        callback.onSuccess(result);
                    }
                });
    }

    public void find(final WarpCallback callback) {
        warp.getService().findAll(className, header, body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WarpResult>() {
                    @Override
                    public void onCompleted() {
                        callback.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e);
                    }

                    @Override
                    public void onNext(WarpResult result) {
                        callback.onSuccess(result);
                    }
                });
    }

    public void findById(int id, final WarpCallback callback) {
        warp.getService().first(className, header, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WarpResult>() {
                    @Override
                    public void onCompleted() {
                        callback.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e);
                    }

                    @Override
                    public void onNext(WarpResult result) {
                        callback.onSuccess(result);
                    }
                });
    }

    public void destroy(int id, final WarpCallback callback) {
        warp.getService().delete(className, header, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WarpResult>() {
                    @Override
                    public void onCompleted() {
                        callback.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e);
                    }

                    @Override
                    public void onNext(WarpResult result) {
                        callback.onSuccess(result);
                    }
                });
    }

}
