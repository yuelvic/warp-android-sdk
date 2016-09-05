package com.yuelvic.warptest.http;

import com.yuelvic.warptest.utils.WarpResult;

import java.util.HashMap;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by yuelvic on 9/2/16.
 */
public interface WarpService {

    @POST("{className}")
    Observable<WarpResult> insert(@Path("className") String className,
                                  @HeaderMap HashMap<String, String> header,
                                  @Body HashMap<String, Object> body);
    @GET("{className}")
    Observable<WarpResult> findAll(@Path("className") String endpoint,
                                                @HeaderMap HashMap<String, String> header,
                                                @QueryMap HashMap<String, Object> constraint);
    @GET("{endpoint}/{id}")
    Observable<HashMap<String, Object>> first(@HeaderMap HashMap<String, Object> header,
                                                 @Path(value = "endpoint", encoded = true) String endpoint,
                                                 @Path("id") int id);
    @PUT("{endpoint}/{id}")
    Observable<HashMap<String, Object>> update(@HeaderMap HashMap<String, Object> header,
                                               @Path(value = "endpoint", encoded = true) String endpoint,
                                               @Path("id") int id, @Body HashMap<String, Object> body);
    @DELETE("{endpoint}/{id}")
    Observable<HashMap<String, Object>> delete(@HeaderMap HashMap<String, Object> header,
                                               @Path(value = "endpoint", encoded = true) String endpoint,
                                               @Path("id") int id);

}
