package com.yuelvic.warptest.http;

import com.yuelvic.warptest.utils.WarpResult;
import com.yuelvic.warptest.utils.WarpUser;

import java.util.HashMap;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by yuelvic on 9/2/16.
 */
public interface WarpService {

    @POST("login")
    Observable<WarpUser> login(@HeaderMap HashMap<String, String> header,
                               @Query("username") String username,
                               @Query("password") String password);

    @POST("{className}")
    Observable<WarpResult> insert(@Path("className") String className,
                                  @HeaderMap HashMap<String, String> header,
                                  @Body HashMap<String, Object> body);
    @GET("{className}")
    Observable<WarpResult> findAll(@Path("className") String endpoint,
                                   @HeaderMap HashMap<String, String> header,
                                   @QueryMap HashMap<String, Object> constraint);
    @GET("{className}/{id}")
    Observable<WarpResult> first(@Path(value = "endpoint", encoded = true) String endpoint,
                                 @HeaderMap HashMap<String, String> header,
                                 @Path("id") int id);
    @PUT("{className}/{id}")
    Observable<WarpResult> update(@Path(value = "endpoint", encoded = true) String endpoint,
                                  @HeaderMap HashMap<String, String> header,
                                  @Path("id") int id,
                                  @Body HashMap<String, Object> body);
    @DELETE("{className}/{id}")
    Observable<WarpResult> delete(@Path(value = "endpoint", encoded = true) String endpoint,
                                  @HeaderMap HashMap<String, String> header,
                                  @Path("id") int id);

}
